import java.util.Scanner;
import java.io.File;

public class Wordcount {

	public static void main(String[] args) {
		//gets user input and puts it into lowercase
		System.out.println("Input word to search for.");
		Scanner top = new Scanner(System.in);
		String word = top.next();
		word = word.toLowerCase();
		String sample;
		int count = 0;
		
		try{ 
			//gets file input
			File file = new File("myfile.txt");
		    Scanner in = new Scanner(file); 
		    //while runs as long as there are more words in file
		    while(in.hasNext()) {
		    	sample = in.next();
		    	//strips punctuation
		    	if (sample.contains(".") || sample.contains(";") || sample.contains(",")){
		    		sample = sample.substring(0, sample.length()-1);
		    	}
		    	//increments count var if word equals user input
		    	if(word.equals(sample.toLowerCase())) {
		    		count++;
		    	}
		    }
		    System.out.println("There are " + count + " instances of " + word + ".");
		   
		  
		}
		catch(Exception e){ 
			//exception catch
			System.out.println(e);
		}
	}
}
