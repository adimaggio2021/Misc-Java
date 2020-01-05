import java.util.Scanner;
import java.io.File;

public class MajorDataAnalysis {

	public static void main(String[] args) {
		//collect user input
			Scanner in = new Scanner(System.in);
		System.out.println("Enter file name");
		String userfilename = in.nextLine();
		System.out.println("Enter number of years");
		int yearnum = in.nextInt();
		//call methods
		StudentTotal(userfilename,yearnum);
		GenderPercent(userfilename,yearnum);
		PercentChange(userfilename, yearnum);
		/*While analyzing the data for the engineering major, I observed that male students outnumber female students by over 4:1
		I also observed that the number of male students is increasing at a greater rate than the number of female students.
		I do not know enough about this field to explain this trend
		My 2 questions:
		What is the breakdown of gender and what are the percentage increases for the specific engineering disciplines (chemical, mechanical, etc.)?
		Why is male student growth outpacing female student growth even as Women in STEM initiatives have become mainstream?
		*/
	}
	public static void StudentTotal(String filename, int years) {
		try {
			File file = new File(filename);
			Scanner fileread = new Scanner(file);
			int total = 0;
			//adds each year's total # of students to a grand total
			for (int i=0; i<years; i++) {
				total += Integer.parseInt(fileread.next().replaceAll(",", ""));
			}
			//output total
			System.out.println("The total number of students over " + years + " years is " + total);
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void GenderPercent(String filename, int years) {
		try {
			File file = new File(filename);
			Scanner fileread = new Scanner(file);
			double total = 0.0;
			//finds total # of students over ten years in order to calculate percentages
			for (int i=0; i<years; i++) {
				total += Integer.parseInt(fileread.next().replaceAll(",", ""));
			}
			//finds total number of students in first gender of data
			String gender = fileread.next().replaceAll(",", "");
			double gendertotal = 0.0;
			for (int j = 0; j<years;j++) {
				gendertotal += Integer.parseInt(fileread.next().replaceAll(",", ""));
			}
			//calculate percent of first gender
			double genpercent = gendertotal/total;
			System.out.println("Total number of " + gender + " students: " + gendertotal);
			//take inverse to find percent of second gender
			double inversepercent = 1.0 - genpercent;
			System.out.println("Percent of " + gender + " : " + genpercent);
			if(gender.equals("Male")) {
				int gt2 = (int)(total*inversepercent);
				System.out.print("Total number of Female students: "+ gt2 );
				System.out.println("Percent of Female: " + inversepercent);
			} else {
				int gt2 = (int)(total*inversepercent);
				System.out.println("Total number of male students: " + gt2);
				System.out.println("Percent of Male: " + inversepercent);
			}
					
		}catch(Exception e) {
			System.out.println(e);
		}
	}
		public static void PercentChange(String filename, int years) {
			try {
				File file = new File(filename);
				Scanner fileread = new Scanner(file);
				double second = Integer.parseInt(fileread.next().replaceAll(",", ""));
				double initial = second;
				double last = 0;
				double first;
				double totalpercent = 0.0;
				//adds together the percent change year-over-year for each year available
				for(int i = 0; i<years-1;i++) {
					first = second;
					second = Integer.parseInt(fileread.next().replaceAll(",", ""));
					last = second;
					totalpercent += (second/first)-1.0;
				}
				//calculates total percent change
				double totalchange = last/initial;
				System.out.println("Total percent change:" + (totalchange-1.0));
				//calculates avg percent change
				double avgpercent = totalpercent/years;
				System.out.println("Total average percent change: " + avgpercent);
				//uses same method to calculate percent change (total and average) with both genders and outputs
				String gendername = fileread.next().replaceAll(",", "");
				System.out.print(gendername + " average percent change: ");
				second = Integer.parseInt(fileread.next().replaceAll(",", ""));
				initial = second;
				totalpercent = 0.0;
				for(int i = 0; i<years-1;i++) {
					first = second;
					second = Integer.parseInt(fileread.next().replaceAll(",", ""));
					last = second;
					totalpercent += (second/first)-1.0;
				}
				totalchange = last/initial;
				double avgpercent2 = totalpercent/years;
				System.out.println(avgpercent2);
				System.out.println(gendername + " total percent change: " + (totalchange-1.0));
				gendername = fileread.next().replaceAll(",", "");
				System.out.print(gendername + " average percent change: ");
				second = Integer.parseInt(fileread.next().replaceAll(",", ""));
				initial = second;
				totalpercent = 0.0;
				for(int i = 0; i<years-1;i++) {
					first = second;
					second = Integer.parseInt(fileread.next().replaceAll(",", ""));
					last = second;
					totalpercent += (second/first)-1.0;
				}
				totalchange = last/initial;
				double avgpercent3 = totalpercent/years;
				System.out.println(avgpercent3);
				System.out.println(gendername + " total percent change:" + (totalchange - 1.0));
				
			}catch (Exception e) {
				System.out.println(e);
			}
		}
}

