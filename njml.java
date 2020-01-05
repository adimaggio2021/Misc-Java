
public class njml {
	public static void main(String[] args) {
		double x = 176529183 ;
		int start = 0;
		for (int groupsize = 1; groupsize < 2012;groupsize++) {
			for(int difference = 0; difference<groupsize; difference++) {
				start = 0 - difference;
			int total = 0;
			int count = 0;
			for(int h = start; count<groupsize;h++) {
				total += h;
				count++;
			}
			double tot = total;
			double div = groupsize;
			double result = (x+tot)/div;
			if(result % 1.0 == 0) {
			System.out.println("Groupsize: " + groupsize + "n: " + result);
			}
			}
			
		}
	}

}
