package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
	private static Resultable r;
	public static void main(String[] args) throws Exception{
		
		//instance of the file parse class
		FileParser file = new FileParser();
		
		//creates a concurrentHashMap and parses the 4grams.txt file
		Map<String, Double> qgm = new ConcurrentHashMap<String, Double>();
		qgm = file.parse("4grams.txt");
		
		//instance of the TestScorer class 
		TextScorer ts = new TextScorer(qgm);
		
	
		 int key = 0;	
		 int choice = 0;
		 String encr = "";
		 String encryptMessage = " ";
		 
		 
		 Scanner input = new Scanner(System.in);
		 
		 do{   //do while runs until -1 is entered by the user
				System.out.println("1: Enter a file to Encrypt\n"
						+ "2: Enter a string be encrypted\n"
						+ "3: -1 to exit"); 
				choice = input.nextInt(); 
				input.nextLine();
	        switch (choice) {
	            case 1: 
	            	System.out.println("Enter the file path: \n");
	                String filePath = input.nextLine();//file path is taken from the user and put into variable filePath
	                StringBuffer sb = new StringBuffer(); 
	                //string filePath is added to the BufferedReader
	                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
	                String line = " ";
	                while((line = br.readLine()) != null){
	                	//replaces all the instances of lower case letters with upper case and 
	                	//any other charther is replaced with a blank space
	                	sb.append(line.replaceAll("[^a-zA-Z]+", "").toUpperCase());
	                }
	                br.close();
	                String plainText = sb.toString();
	                
	                System.out.println("Gimme the key");
	                key = input.nextInt();
	                //Plaintext and key added to encrypt method
	                String h = new Encrypt().encrypt(plainText, key);
	                //passes in an Encrypt object h to CyperBreaker
	          
	                CyperBreaker cp1 = new CyperBreaker(h);
	                //cp1.toString();
	                break;
	            case 2:  
	            	System.out.println("Enter the message to be encrypted: \n");
	            	encryptMessage = input.nextLine();
	                
	                System.out.println("Gimme the key");
	                key = input.nextInt();
	                
	                String f = new Encrypt().encrypt(encryptMessage, key);
	                
	                CyperBreaker cp = new CyperBreaker(f);
	            	cp.toString();
	              break;
	        }
		 }while(choice != -1);
			
	   
		 
	}
}



