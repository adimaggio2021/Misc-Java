// STUDENT VERSION

// Risk Assessment.java
// Name:
// Date:
// Adapted from Jillian Cardamon 6/6/18

/* Idea (from article): each inmate is assigned a true probability of 
   reoffending based on normal distribution mean and std dev from the 
   Ohio data - weighted avg = 21.79, std dev = 13.85 then the computer 
   uses those probabilities to decide whether each dot will actually 
   reoffend a dot with a 75% risk will on average reoffend 3/4 times no 
   one knows the true chance of reoffending so risk assessment tries to 
   estimate it normal distribution with mean set at true risk and std 
   dev 0.15 can use random.gauss(mu, sigma) for normal distribution
*/

import java.util.*;

public class Risk_Assessment{
    public static double lowCutOff = 0;
    public static double mediumCutOff = 0;
    public static double highCutOff = 43;

    public static Defendant[] defendants;
    public static ArrayList<Defendant> awardedParole;
    public static ArrayList<Defendant> deniedParole;
    
    public static void printDefendantList(Defendant[] l){
	// given an array of defendants, print out each defendant
	// to help debugging

	for (Defendant d: l)
	    System.out.println(d);
    }

    public static Defendant[] createDefendants(){
    	Random r = new Random();
    	double trueRisk;
    	double reoffend;
    	defendants = new Defendant[100];
    	//initializes 100 defendants white truerisks with desired standard dev. and mean
    	for(int i = 0; i<100;i++) {
    		trueRisk = 45;
    		while(trueRisk>43 || trueRisk <0) {
    		trueRisk = r.nextGaussian()*13.85 +21.79;
    		}
    		reoffend = r.nextDouble()*43.0;
    		//test for if defendant reoffends or not. Higher truerisk = higher chance of recidivism
    		if(reoffend>trueRisk) {
    			defendants[i] = new Defendant(trueRisk, false);
    		} else {
    			defendants[i] = new Defendant(trueRisk, true);
    		}
    	}
    	return defendants;
    	
    }

    public static double[] chooseCutOffs(){
	Scanner in = new Scanner(System.in);
	System.out.println("INPUT PERCENT DOUBLE FOR UPPER BOUND OF LOW CUTOFF");
	//sets instance ariable cutoffs
	double[] cutoffs = new double[3];
	lowCutOff = 43*in.nextDouble();
	System.out.println("INPUT PERCENT DOUBLE FOR UPPER BOUND OF MEDIUM CUTOFF");
	mediumCutOff = 43*in.nextDouble();
	cutoffs[0] = lowCutOff;
	cutoffs[1] = mediumCutOff;
	cutoffs[2] = 43.0;
	return cutoffs;
    }

    public static void assessDefendants(){
    	Defendant d;
    	for(int i = 0;i<100;i++) {
    		d = defendants[i];
    		//assesses defendants and decides parole for each
    		d.assess(lowCutOff, mediumCutOff, highCutOff);
    		d.decideParole();
    	}
    	
    }

    public static void paroleStats(){
    	int released = 0;
    	int denied= 0;
    	int denreoffend = 0;
    	int relreoffend = 0;
    	Defendant d;
    	//collects data on how many are paroled/realeased and how many of each constituency reoffends or not
    	for(int i = 0;i<100;i++) {
    		d = defendants[i];
    		if (d.isGivenParole() == true) {
    			released++;
    			if(d.willOffendAgain() == true) {
    				relreoffend++;
    			}
    		}
    		if (d.isGivenParole() == false) {
    			denied++;
    			if(d.willOffendAgain() == false) {
    				denreoffend++;
    			}
    		}
    	}
    	//output results
    	System.out.println(released + " defendants were released. Out of this group, " + relreoffend + " will reoffend.");
    	System.out.println(denied + " defendants were denied parole. Out of this group, " + denreoffend + " would not have gone on to reoffend");
    }
        
    public static void main(String[] args){
    	createDefendants();
    	chooseCutOffs();
    	assessDefendants();
    	paroleStats();
    	
    	
    }
	    
	/*
	 Reflection:
	 1.Some of the pros of using algorithms is that they can remove human biases from decision making.
	 Also, algorithms can take into account a wide set of data to make well informed decisions.
	 The cons are that risk assessment algorithms can be inadvertently biased against certain groups.
	 In addition, there are concerns that these algorithms prevent decisions from being tailored to the specifics of each case.
	 There are also arguments that these algorithms violate legal rights by obscuring how decisions are made and essentially punishing
	 offenders for what previous criminals have done.
	 2.I do not think that algorithms have a place right now in our criminal justice system. While completely removing
	 human faults from the justice system is an admirable goal, I do not believe that algorithms do not yet have the complexity
	 to effectively make such nuanced decisions.
	 3.No I do not think fully unbiased algorithms are possible to create. We may be able to create less biased, more accurate
	 algorithms through evolutionary design processes. However, there is only so much data that one can gather on each defendant.
	 Because of the relative brevity of this data, there is no way to fully eliminate biases.
	 4.In the documentary 13th, we learned how many black Americans, though free from slavery, have remained in chains under the criminal justice system.
	 With this lab, we learned how algorithms, though intended to reduce incarceration, has actually contributed to the problem through harsh sentences
	 and skewed decision-making.
	 5.The reading focuses in on the sentencing aspect of risk assessments. Recently, Pennsylvania
	 started using assessment scores in sentencing. This raises the question on whether these assessments are
	 just a form of unethical group punishments. Individual defendants serve longer because of the way 
	 in which the groups they belong to have behaved before. The reading also points out that the algorithms do not 
	 entirely eliminate human bias. Humans are entering the questions to be entered into the program, and some of these questions
	 are subjective. In the dynamic criminal justice system, it is difficult to a evaluate the effectiveness of any one program
	 However, the reading also discusses the success of one assessment-based program. Based on risk categorizations,
	 different defendants were assigned different parole officers and the defendants had to follow different conditions. High risk
	 meant the defendant was likely to commit a violent crime. Medium meant the defendant would commit a crime, but 
	 one that was non-violent. Low-risk corresponded to those who were not likely to commit any crime.
	 The results were positive: recidivism fell and parole supervisors were able to better manage their workload. 
	 If our nation does decide to go down this road, we will soon have to decide how far we are willing to go.
	 Questions will soon arise: Are algorithms trustworthy enough to completely control the justice system?
	 If we can predict with certainty that someone will commit a crime in the future, is it ethical to detain them before anything even happens?
	 */
    
	



}
