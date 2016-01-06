package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.*;

public class CypherBreaker {
	private static final int MAX_QUEUE_SIZE=1000;
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	
	public CypherBreaker(String cypherText){
		queue= new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cypherText= cypherText;
		init();
	}
	
	public void init(){
		//start a load of producers
		for (int i=2;i <cypherText.length()/2;i++){
			new Thread(new Decryptor(queue, cypherText,i)).start();
		}
		
		
	}
	
	/*
	 * volotile int counter =0;
	 * object lock= new object();
	 * public void increment(){
	 * synchronized (lock){
	 * counter ++;
	 * if(counter == 1000){
	 * queue.put (new PosinResult());
	 * }
	 * }
	 * 
	 */

}
