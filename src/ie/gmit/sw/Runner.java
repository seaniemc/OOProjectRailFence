package ie.gmit.sw;

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
	 
	 Scanner encrFile = new Scanner(System.in);
	 
	 Scanner input = new Scanner(System.in);
	 
	 do{
			System.out.println("1: Enter a file to Encrypt\n"
					+ "2: Enter a string be encrypted\n"
					+ "3: -1 to exit"); 
			choice = input.nextInt(); 
        switch (choice) {
            case 1: 
            	//file=input.next();
            	System.out.print("Enter the file name with extention and the key: \n");
                encryptMessage = encrFile.next();
                key = input.nextInt();
                String h = new Encrypt().encrypt(encryptMessage, key);
                //encr = h;
                CyperBreaker cp1 = new CyperBreaker(h);
            	r=cp1.getFinalResult();
            	System.out.println(r.getPlainText() + " Score: " + r.getScore() + " Key: " + r.getKey());
                break;
            case 2:  
            	System.out.print("Enter the message to be encrypted and the Key: \n");
            	encryptMessage = encrFile.nextLine();
                key = input.nextInt();
                String f = new Encrypt().encrypt(encryptMessage, key);
                
                CyperBreaker cp = new CyperBreaker(f);
            	r=cp.getFinalResult();
            	System.out.println(r.getPlainText() + " Score: " + r.getScore() + " Key: " + r.getKey());
              break;
        }
	 }while(choice != -1);
		
	
	//System.out.println(">" + s);
	//System.out.println(encrypted);
	
	//CyperBreaker cp = new CyperBreaker(encr);
	//r=cp.getFinalResult();
	//System.out.println(cp.getFinalResult());
	
	//System.out.println(r.getPlainText() + " Score: " + r.getScore() + " Key: " + r.getKey());
	
	}
}



