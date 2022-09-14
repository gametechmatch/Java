/*********************************************************************************
 * baseballERACalculator.java
 * @author Lily Zimmermann
 *
 * Fall 2021
 *This program prints the ERA of a pitcher of the user's choosing.
 *
 *Notes: 
 *For the number of innings pitched, I set the limit to start at 1 since otherwise
 *the program said that the ERA was infinite. 
 ********************************************************************************/


import java.util.Scanner;

public class baseballERACalculator
{
	public static void main(String[] args)
	{		
		Scanner scan = new Scanner(System.in); // Create an input scanner for keyboard
//start of variable declaration section
		String firstNamePitcher;
		String lastNamePitcher;
		int numberOfEarnedRuns = -1;
		int numberOfInningsPitched = 0;
		double pitchersERA;
//start of first input section for the first and last name of the pitcher	
		System.out.println("Hello! Let's figure out the ERA of the baseball pitcher of your choosing.");
		System.out.println("Don't know what an ERA is? The ERA is a baseball player's earned run average.");
		System.out.println("");
		System.out.print("Now let's first start with the pitcher's first name: ");
			firstNamePitcher = scan.nextLine();		

		System.out.print("The pitcher's last name: ");
		lastNamePitcher = scan.nextLine();
		System.out.println("");
		
//start of number of earned runs input section with while loop to stop invalid input
		while( numberOfEarnedRuns < 0) {
			System.out.print("Their number of earned runs: ");

			String input = scan.nextLine();
			
			try 
			{
				numberOfEarnedRuns = Integer.valueOf(input);
			} 
			catch (NumberFormatException e) 
			{
				numberOfEarnedRuns = -1;
				System.out.println("I'm sorry. I can only accept whole numbers at 0 or above for this question.");
			} //end of section that catches invalid input for the number of earned runs
		}	//end of while loop

//start of number of innings pitched with while loop to stop invalid input
		while( numberOfInningsPitched < 1) {
			System.out.print("Their number of innings pitched: ");
			
			String input = scan.nextLine();
			
			try 
			{
				numberOfInningsPitched = Integer.valueOf(input);
			} 
			catch (NumberFormatException e) 
			{
				numberOfInningsPitched = 0;
				System.out.println("I'm sorry. I can only accept whole numbers at 1 or above for this section.");
			}	//end of section that catches invalid input or the number of innings pitched
		}	//end of while loop

//start of calculations section
		pitchersERA = ((((double) numberOfEarnedRuns)*9) / numberOfInningsPitched);

//start of output section 
		System.out.println("Thank you! " + firstNamePitcher + " " + lastNamePitcher + " has an ERA of " +
				pitchersERA + ".");	
	}	//end main
}	//end class
