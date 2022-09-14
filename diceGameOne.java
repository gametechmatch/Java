/*****************************************************************************
 * diceGameOne.java
 * @author Lily Zimmermann
 * 
 * Semester: Fall 2021
 * 
 * This program is a simple dice game
 *****************************************************************************/
import java.util.Scanner;

public class diceGameOne
{
	public static void main (String[] args)
	{
		Scanner stdIn = new Scanner(System.in);

//dice variables		
		int d1;
		int d2;
		int d3;
		int d4;
		
//variables to keep track of the number of times the player lost, number of times won, and total games	
		int numberOfWins = 0;
		int numberOfLosses = 0;
		int totalNumberOfGames = 0;

//boolean variables for the first time playing the game and any future times playing the game
		boolean valid = false;
		boolean donePlayingAdditionalRounds = false;
		
//variable for user input if they want to keep playing or quit the game
		String userPlayingChoice;
		
//variables to check if the user entered a p to play or q to quit (not case sensitive)
		String yesPlaying = "p";
		String noPlaying = "q";

//beginning of game asking if player wants to play		
		System.out.println("Hello! Welcome to lucky die gaming center! You will be given the chance to roll 4 dice.");
		System.out.println("If any of the die match, you win! If none of the die match, you lose.");

		do
		{
			System.out.print("Would you like to play? Enter P to play or Q to quit: ");
			userPlayingChoice = stdIn.nextLine();
			if (userPlayingChoice.equalsIgnoreCase(yesPlaying))
			{ 
				d1 = (int)(Math.random() * 4) + 1;
				d2 = (int)(Math.random() * 4) + 1;
				d3 = (int)(Math.random() * 4) + 1;
				d4 = (int)(Math.random() * 4) + 1;
				
				System.out.println();
				System.out.println("Your four dice are: " + d1 + " " + d2 + " " + d3 + " " + d4);
				if (d1 == d2 && d2 == d3 && d3 == d4)
				{
					numberOfWins++;
					totalNumberOfGames++;
					System.out.println("You won! This is a quad");
					System.out.println();
				}
				else if (d1 == d2 && d2 == d3 || d2 == d3 && d3 == d4 || d1 == d3 && d3 == d4 || d1 == d2 && d2 == d4)
				{
					numberOfWins++;
					totalNumberOfGames++;
					System.out.println("You won! This is a triple");
					System.out.println();
				}
				else if (d1 == d2 || d1 == d3 || d1 == d4 || d2 == d3 || d2 == d4 || d3 == d4)
				{
					numberOfWins++;
					totalNumberOfGames++;
					System.out.println("You won! This is a pair");
					System.out.println();
				}
				else if (d1 == 4 && d2 == 4 || d1 == 4 && d3 == 4 || d1 == 4 && d4 == 4 || d2 == 4 && d3 == 4 || d2 == 4 && d4 == 4 || d3 == 4 && d4 == 4)
				{
					numberOfWins++;
					totalNumberOfGames++;
					System.out.println("You won! This is a high pair");
					System.out.println();
				}
				else
				{
					numberOfLosses++;
					totalNumberOfGames++;
					System.out.println("I'm sorry. You lost.");
					System.out.println();
				}
			}
			else if (userPlayingChoice.equalsIgnoreCase(noPlaying))
			{
				
				System.out.println("Your total wins are: " + numberOfWins + " and your total losses are " + numberOfLosses);
				System.out.println("You played " + totalNumberOfGames + " games.");
				System.out.println("Goodbye");
				valid = true;
			}
			else 
			{
				System.out.println();
				System.out.println("I'm sorry. That's not a valid entry.");
				System.out.print("Would you like to play? Enter P to play or Q to quit: ");
				stdIn.reset();
			}
		} while (!valid);
	}	//end main
}	//end class
