import java.io.*;
import java.lang.*;
import java.util.*;
public class CustomisedLevelClass2 extends LevelClass{
	String random_alphabets="";
	
	Random rand = new Random();
	public String[] CreateButton(String word_got){
	      
		   String[] letters=null;
		   //to generate ten more extra keys
		   while(random_alphabets.length()<=10){
			   
				String single_letter=""+(char)(rand.nextInt(26) + 'a');
				if(!word_got.contains(single_letter) && !random_alphabets.contains(single_letter))
					random_alphabets +=single_letter;
		   }
		   //this is to add the buttons which have alphabets of the answer
		   for(int i=0;i<word_got.length();i++){
			   char single_word_letter=word_got.charAt(i);
			   String letters_of_the_word=""+single_word_letter;
			   //to make sure that if a word like apple .p shouldnt get added twice
			   if(!random_alphabets.contains(letters_of_the_word))
				   random_alphabets+=letters_of_the_word;
		   }
		   //since the buttons are needed in upper case
		   random_alphabets=random_alphabets.toUpperCase();
		   //now the string splits and each split one is a string
		   letters=random_alphabets.split("");
		   //in built function for sorting the alphabets is Arrays.sort(arrayname)
		   Arrays.sort(letters);
		   return letters;
		      
	   }
		
	
		 
}	
