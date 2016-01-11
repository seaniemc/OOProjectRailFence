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
		
		FileParser file = new FileParser();
		
		Map<String, Double> qgm = new ConcurrentHashMap<String, Double>();
		qgm = file.parse("4grams.txt");
		
		TextScorer ts = new TextScorer(qgm);
		
		//String encrypted = ("THEYARENEARTHEGATESMANTHEWALLSANDCLOSETHEGATES");
		//String s = new Encrypt().encrypt(encrypted, 5);
	
	 int key = 0;	
	 int choice = 0;
	 String encr = "";
	 String encryptMessage = " ";
	 
	 
	 Scanner input = new Scanner(System.in);
	 
	 do{
			System.out.println("1: Enter a file to Encrypt\n"
					+ "2: Enter a string be encrypted\n"
					+ "3: -1 to exit"); 
			choice = input.nextInt(); 
			input.nextLine();
        switch (choice) {
            case 1: 
            	//file=input.next();
            	System.out.println("Enter the file path: \n");
                String filePath = input.nextLine();
                StringBuffer sb = new StringBuffer(); 
                
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                String line = " ";
                while((line = br.readLine()) != null){
                	sb.append(line.replaceAll("[^a-zA-Z]+", "").toUpperCase());
                }
                br.close();
                String plainText = sb.toString();
                
                System.out.println("Gimme the key");
                key = input.nextInt();
                String h = new Encrypt().encrypt(plainText, key);
                //encr = h;
                CyperBreaker cp1 = new CyperBreaker(h);
                
                // r=cp1.getFinalResult();
                break;
            case 2:  
            	System.out.println("Enter the message to be encrypted and the Key: \n");
            	encryptMessage = input.nextLine();
                key = input.nextInt();
                System.out.println(encryptMessage + key);
                
                String f = new Encrypt().encrypt(encryptMessage, key);
                
                CyperBreaker cp = new CyperBreaker(f);
            	// r=cp.getFinalResult();
              break;
        }
	 }while(choice != -1);
		
	
	//System.out.println(">" + s);
	//System.out.println(encrypted);
	
//	CyperBreaker cp = new CyperBreaker(s);
//	r=cp.getFinalResult();
	//System.out.println(cp.getFinalResult());
//	if (r.getScore() > -2000) {
    System.out.println(r.getPlainText().substring(0, 15) + " Score: " + r.getScore() + " Key: " + r.getKey());
//	}
	
	}
}



