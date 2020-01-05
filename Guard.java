/* Advent of Code Adaptation Day 4
 * Guard.java
 */

import java.util.*;

public class Guard{
    private int number;
    private ArrayList<Shift> shifts;
    String kek;

    public Guard(int n, Shift s) {
    number = n;
    shifts = new ArrayList<Shift>();
    shifts.add(s);
    }
   

    public String toString() {
	/* returns a string form of the class for testing purposes */
    	int i = 1;
    	for(Shift shift: shifts) {
    		//prints all the shifts
    		System.out.println("Shift " + i + ": " + shift.napLength() + " minutes.");
    		i++;
    	}
    	//shows guard's number and amount of time slept
    	String s = Integer.toString(number) + " " + Integer.toString(this.totalHoursAsleep()); ;
    	return s;
    }
    
    public String getKek() {
    	return kek;
    }

    public int getNumber() {
	/* returns the guards number */
    	return number;
    }

    public void addShift(Shift shift) {
	/* add another Shift object to the shifts ArrayList */
    	shifts.add(shift);
    }

    public int totalHoursAsleep() {
	/* calculate the total hours this guard has napped */
    	int total = 0;
    	for(Shift shift: shifts) {
    		total += shift.napLength();
    	}
    	return total;
    }
    
}
