package p1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        //console input
		Scanner scanner = new Scanner(System.in);
       while(true)
       {
    	   System.out.println("----------------------------------------------------------");
    	   //Providing Options To Select
        System.out.println("Enter 'T' to input the Text" +'\n'
        		+ "Enter 'F' to input from a File: ");
        char option = scanner.next().charAt(0);
        //Storing the Option
        String input = "";

        if (option == 'T' || option == 't')
        {
            System.out.println("Enter the text:");
            scanner.nextLine();
            input= scanner.nextLine();  
        } 
        else if (option == 'F' || option == 'f') {
            System.out.println("Enter the file path: ");
            String filePath = scanner.next();
            
            try {
            	//Sending the filePath to Buffer Object by Using FileReader Class
                BufferedReader buffer = new BufferedReader(new FileReader(filePath));
                //Creating StringBuilder Class
                StringBuilder sb = new StringBuilder();
             
                while ((buffer!= null))
                {
                    sb.append(filePath);
                }
                		input = sb.toString();
            } catch (Exception e) {
                System.err.println("Cannot Find The File: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        String[] noOfwords = input.split("[, .]");
        int wordsCount = noOfwords.length;

        System.out.println("Total words: " + wordsCount);

       }
    }
}
