
package ie.gmit.sw;

import java.util.concurrent.*;

public class CyperBreaker {
	private static final int MAX_QUEUE_SIZE = 1000;
	private double finalScore = 0.0;
	private Resultable finalResult = null;
	private BlockingQueue <Resultable> queue;
	private String cyperText;
	
	public CyperBreaker(String text){
		
		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cyperText = text;
		
		init();
	}

	private void init() {
		//start producers
		
		for(int i = 2; i < cyperText.length()/2; i++){
			new Thread (new Decryptor(queue, cyperText,i)).start();
		}
		
			Thread t = new Thread(new Runnable(){
				public void run(){
					while (! queue.isEmpty()){
						try{
							Resultable r = queue.take();
							double score = r.getScore();
							if(score > finalScore){
								finalScore = score;
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
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public Resultable getFinalResult(){
			
			return finalResult;
		}
		
		public String toString(){
			return("text -> " + finalResult.getPlainText() + "; Key -> " + finalResult.getKey() + "; Score -> " + finalResult.getScore());
		}
	}

