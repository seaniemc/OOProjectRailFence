package ie.gmit.sw;


import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser {
	public  Map<String, Double> parse(String file) throws IOException {
	
	String key;
	Double value;
	String line = "";
	
	Map<String, Double> qgm = new ConcurrentHashMap<String, Double>();
	
	//read file
	try{
		BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		while((line = reader.readLine()) != null){
			
			String[] arr = line.split(" ");
			
			key = arr[0];
			value = Double.parseDouble(arr[1]);
			
			qgm.put(key, value);
		}
	}catch (Exception e){
		System.err.println(e.getMessage());
	}
	
	return qgm;
	}
}
