
package ie.gmit.sw;

import java.util.concurrent.*;

public class CyperBreaker {
	private static final int MAX_QUEUE_SIZE = 1000;
	private double finalScore = -333320.0;
	private Resultable finalResult = null;
	private BlockingQueue <Resultable> queue;
	private String cyperText;

	public CyperBreaker(String text) throws InterruptedException{

		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cyperText = text;

		init();
	}

	private void init() throws InterruptedException {
		//creates a thread pool half the size of te cypherText
		ExecutorService executor = Executors.newFixedThreadPool(cyperText.length()/2);
		for(int i = 2; i < cyperText.length()/2; i++){
			executor.submit(new Decryptor(queue, cyperText,i));
		}
		// executor.submit(new Decryptor(queue, "POISEN", 9999)); P:OISEN OBJECT??

		executor.shutdown();

		Thread t = new Thread(new Runnable(){
			public void run(){

				while (!queue.isEmpty()){
					try{
						Resultable r = queue.take(); //removes the head of this queue, waiting if necessary until an element becomes available
						//	double score = r.getScore();
						if(r.getScore() > finalScore){//compares getScore to finalScore 
							finalScore = r.getScore();
							finalResult = r; 
						}

					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}

		});
		t.start();

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		t.join();
		
		System.out.println("All threads done");
		//prints out a sub string of the first 20 characters and the key
		System.out.println(finalResult.getPlainText().substring(0, 20) + "... Key" + finalResult.getKey());


	}
	public Resultable getFinalResult(){

		return finalResult;
	}

	public String toString(){
		return("text -> " + finalResult.getPlainText() + "; Key -> " + finalResult.getKey() + "; Score -> " + finalResult.getScore());
	}
}

