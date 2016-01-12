package ie.gmit.sw;

/*
 * This class reads in the 4grams.txt file, splits it and puts it into a ConcurrentHashMap.
 */

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser {
	public  Map<String, Double> parse(String file) throws IOException {
	
	String key;
	Double value;
	String line = "";
	
	Map<String, Double> qgm = new ConcurrentHashMap<String, Double>();//takes a string double combination
	
	//read file
	try{
		BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		while((line = reader.readLine()) != null){
			
			String[] arr = line.split(" ");
			
			key = arr[0];//puts the string value of 4grams.txt into the array 
			value = Double.parseDouble(arr[1]);//parses the double value into second position of the string array.
			
			qgm.put(key, value);//puts the key and the value variables into the ConcurrentHashMap qgm
		}
	}catch (Exception e){
		System.err.println(e.getMessage());
	}
	
	return qgm;
	}
}
