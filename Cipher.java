/**
	Made by Sea
	On the weeks up to 20/04/2014
	Really difficult, but worth it
	CSP1150, ECU.
	This code ciphers a word from
	a notepad file according to a 
	certain provided keyword :)
*/


import java.util.Scanner;
import java.lang.String;
import java.io.*;


public class Cipher
{
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the keyword: ");
		String keyword = scanner.nextLine(); //Keyword
		char[] char1 = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
				'n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String alph = new String(char1);
		String beta = keyword.toLowerCase() + alph;
		char[] beta2 = beta.toCharArray();
		String word2 = ""; //Empty word to change into the new array
		for(int i = 0; i < beta.length(); i++) 
		//Cycles through the length of the combined string
		{
			if(word2.indexOf(beta2[i]) == -1) //Check for repeated letters
			{
				word2 = word2 + beta2[i]; //If the char isn't repeated, add it
				//System.out.println(word2); //Check the word, see the steps
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the name of the file? (succeeded by .txt)");
		String firs = sc.nextLine();
		Scanner scanFile = new Scanner(new File(firs));
		System.out.println(); //To get the next line;
		//System.out.print("Enter the word: ");
		System.out.println("Compare the following to see the changes:");
		System.out.println(alph); //Compare 1
		System.out.println(word2);//with 2
		while(scanFile.hasNextLine())
		{
			String word = (scanFile.nextLine()).toLowerCase(); //Keyword
			char[] cha = word.toCharArray();
			System.out.println("\n" +word);
			//Decipher
			decipher(word, alph, word2);
		}
	}
	// This method ciphers the word
	public static void decipher(String word, String alph, String beta)
	{	
		char[] cha1 = word.toCharArray();
		char[] cha2 = alph.toCharArray();
		char[] cha3 = beta.toCharArray();
		String change = "";
		for(int i = 0; i < word.length(); i++)
		{
			if(Character.isLetter(cha1[i]))
			{
				int ind = alph.indexOf(cha1[i]);
				change = change + cha3[ind];
				//System.out.println(change);
			}
			else
			{
				change = change + cha1[i];
			}
		}
		System.out.println("Ciphered Word: \n" + change);
	}	
}
