// AP CS 18-19
// Testing and Debugging Activity

import java.util.*;


public class Quiz{

    public Scanner in;

    public static boolean isYes(String text){
	return text.toLowerCase() == "yes";
    }

    public static ArrayList makeQuestions(){
	int num = 0;
	while(isYes(in.next())){
	    System.out.println("Do you want a free response or multiple choice question? Enter F or M. ");
	    String type = in.next();
	    String text;
	    if (type.equals("F")){
		System.out.println("Enter the text of your question. ");
		text = in.next();
		System.out.println("Enter the answer to your questions. ");
		String answer = in.next();
		qs += new Question(text, answer, num);
		num++;
	    }
	    else{
		System.out.println("Enter the text of your question. ");
		System.out.println("How many answer choices do you have? ");
		MultipleChoice m = new MultipleChoice(text, "", num);
		int numChoices = in.nextInt();
		for (int i = 0; i < numChoices; i++){
		    System.out.println("Enter choice: ");
		    String choice = in.next();
		    System.out.println("Is this choice correct? yes or no ");
		    boolean isCorrect = isYes(in.next());
		    m.addChoice(choice, isCorrect);
		}
		qs.add(m);
	    }
	    System.out.println("Do you have any more questions? yes or no");
	} 
    return qs;
    }

    
    
    public static void askQuestions(ArrayList<Question> questions){
	for (MultipleChoice q: questions){
	    q.display();
	    System.out.println("Enter the answer to the question. If it is multiple choice enter the letter.");
	    if (q.checkAnswer(in.next())){
		System.out.println("Correct!");
	    }
	    else{
		System.out.println("Incorrect.");
	    }
	}
	System.out.println("You have finished the quiz.");
    }


    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	makeQuestions();
	askQuestions();	
    }
}
	
