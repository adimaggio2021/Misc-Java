// STUDENT VERSION

// Defendant.java
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

public class Defendant{
    private double trueRisk;
    private boolean willReoffend;
    private double assessmentScore;
    private String riskCategory;
    private boolean givenParole;

    Defendant(double risk, boolean reoffend){
	// constructor
	trueRisk = risk;
	willReoffend = reoffend;
	assessmentScore = 0;
	riskCategory = null;
	givenParole = false;
    }

    public String toString(){
	// toString
	return "Assessment Score: " + this.assessmentScore + '\n' +
	    "Risk Category: " + this.riskCategory + '\n' +
	    "Will Reoffend: " + this.willReoffend + '\n' +
	    "Given Parole: " + this.givenParole;
    }

    // accessor methods

    public double getTrueRisk(){ return trueRisk; }
    public boolean willOffendAgain() { return willReoffend; }
    public double getAssessmentScore() { return assessmentScore; }
    public String getRiskCategory() { return riskCategory; }
    public boolean isGivenParole() { return givenParole; }

    // mutator methods

    public void assess(double low, double med, double high){
    	Random r = new Random();
    	//assessment score based on standard dev. of .15 and mean of truerisk
    	assessmentScore = r.nextGaussian()*0.15 + trueRisk;
    	if (assessmentScore <= low) {
    		riskCategory = "low";
    	} else if(assessmentScore <= med) {
    		riskCategory = "med";
    	}else {
    		riskCategory = "high";
    	}
    }

    public void decideParole(){
	Random r = new Random();
    if(riskCategory.equals("low")) {
		givenParole = true;
	} else if(riskCategory.equals("high")){
		givenParole = false;
	} else if(r.nextDouble()<0.5) {
		//50% chance of parole if in med cat
		givenParole = false;
		
	}else {
		givenParole = true;
	}

    }
}
	
		



