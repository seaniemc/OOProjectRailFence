package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
	private static Resultable r;
	public static void main(String[] args) throws Exception{
	
	String encrypted = ("THEYARENEARTHEGATESMANTHEWALLSANDCLOSETHEGATES");
	
	FileParser file = new FileParser();
	
	Map<String, Double> qgm = new ConcurrentHashMap<String, Double>();
	qgm = file.parse("4grams.txt");
	/*for(Map.Entry<String, Double>entry : qgm.entrySet()){
		System.out.println("Key: " + entry.getKey() + "Value :" + entry.getValue());
	}*/
	TextScorer ts = new TextScorer(qgm);
	
	String s = new RailFence().encrypt(encrypted, 5);
	System.out.println(">" + s);
	System.out.println(encrypted);
	
	CyperBreaker cp = new CyperBreaker(s);
	r=cp.getFinalResult();
	//System.out.println(cp.getFinalResult());
	
	System.out.println(r.getPlainText() + " Score: " + r.getScore() + " Key: " + r.getKey());
	
	}
}



