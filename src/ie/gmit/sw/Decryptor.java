package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryptor implements Runnable {//producer
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	
	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key) {
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key= key;
	}

	public void run() {
		Decrypt dc= new Decrypt();
		String plainText = dc.decrypt(cypherText, key);
		double score= TextScorer.getScore(plainText); 
		
		Resultable r= new Result(plainText, score, key);// create a result
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(plainText +"Score: " + score+ "Key: " + key);
	}
	
}
