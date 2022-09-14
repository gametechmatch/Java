/*****************************************************************************
 * rouletteGame.java
 * @author Lily Zimmermann
 * 
 * Semester: Fall 2021
 * 
 * This program is a roulette game.
 *****************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class rouletteGame
{
	public static void main (String [] args)
	{
// Variables
		Scanner stdIn = new Scanner(System.in);
		boolean donePlaying = false;
		
		String menuChoice;
		String numberOfChipsBetString;
		int numberOfChipsBet;
		
		String numberBet;
		String colorBet;
		
		String spinNum; //winning number
		String winningColor;

		int wins = 0;
		int losses = 0;
		int chipsNow = 100;
		
// Beginning of Game	
		welcome(); //calling welcome method
		
		do
		{			
		stdIn.reset();
		menuChoice = getMenuChoice(stdIn); //calling getMenuChoice method
		
		if (menuChoice.equals("1")) //number bet
		{
			numberOfChipsBetString = getBet(stdIn, chipsNow); //calling getBet method
			numberOfChipsBet = Integer.valueOf(numberOfChipsBetString);
			chipsNow-=numberOfChipsBet;
			
			numberBet = getNumber(stdIn); //calling getNumber method
			spinNum = spinWheel(); //figures out winning number
			
			if (numberBet.equals(spinNum))
			{
				System.out.println("You won!");
				wins++;
				chipsNow+= chipsCalculatorNumberBet(numberOfChipsBet); //calling chipsCalculator method
				System.out.println("Your total chips are: " + chipsNow);
			}
			else
			{
				System.out.println("You lost =(");
				losses++;
				System.out.println("Your total chips are: " + chipsNow);
			}
		}
		else if (menuChoice.equals("2")) //color bet
		{
			numberOfChipsBetString = getBet(stdIn, chipsNow); //calling getBet method
			numberOfChipsBet = Integer.valueOf(numberOfChipsBetString);
			chipsNow-=numberOfChipsBet;
			
			colorBet = getColor(stdIn); //calling getColor method
			spinNum = spinWheel(); //figures out winning number
			winningColor = determineColor(spinNum); //calling determineColor method
			
			if (colorBet.equals(winningColor))
			{
				System.out.println("You won!");
				wins++;
				chipsNow+= chipsCalculatorColorBet(numberOfChipsBet); //calling chipsCalculator method
				System.out.println("Your total chips are: " + chipsNow);
			}
			else
			{
				System.out.println("You lost =(");
				losses++;
				System.out.println("Your total chips are: " + chipsNow);
			}
		}
		else if (menuChoice.equals("3")) //Cash out
		{
			donePlaying = true;
		}
		else 
		{
			System.out.println("I'm sorry. I don't understand.");
		}
	} while (!donePlaying);
		report(wins, losses, chipsNow); //calling report method		
} //end main method

//**********************************************************************************************************************	
	public static void welcome()
	{
		System.out.println("*******************************************************************************************************************");
		System.out.println("*\t\t\t\t\t\tROULETTE!");
		System.out.println("******************************************************************************************************************");
		System.out.println("* Rules:");
		System.out.println("*\tI have a wheel with slots numbered from 0 to 36.\r" + 
		"*\tSlot 0 is green, all other even numbered slots are red, and all odd slots are black.");
		System.out.println("*\tYou start with 100 chips and can either bet on a specific number (0 -36) or bet on a color (red or black).");
		System.out.println("*\tWinning a bet on a number will multiply your bet by 35.\r" +
		"*\tWinning a bet on a color will double your bet. If you lose, you lose the chips you bet.");	
		System.out.println("******************************************************************************************************************");
	} //end welcome method

//**********************************************************************************************************************	
	
	public static String getMenuChoice(Scanner stdIn)
	{
		String menuChoice;	
		boolean validInput = false;

		do {
			System.out.println("\rPlease select an option below:");
			System.out.print("[1] Bet a number [2] Bet a color [3] cash out:");		
			menuChoice = stdIn.nextLine();
			System.out.println("You selected " + menuChoice + ".\r");
			if (menuChoice.equals("1")) 
			{
				validInput = true;
			}
			else if (menuChoice.equals("2"))
			{
				validInput = true;
			}
			else if (menuChoice.equals("3"))
			{
				System.out.println("Sounds good. Cashing out.");
				validInput = true;
			}
			else
			{
				System.out.println("I'm sorry. I don't understand.");
			} 
		} while (!validInput);
		return menuChoice;
	}

//**********************************************************************************************************************
	public static String getBet(Scanner stdIn, int chipsNow)
	{
		String numberOfChipsBetString;
		int numberOfChipsBetInteger;
		
		System.out.println("Your total chips are:" + chipsNow);
		boolean validInput = false;
		
		do 
		{
			stdIn.reset();
			System.out.print("Please place a bet by choosing a whole number between 1 and your total chips:");
			numberOfChipsBetString = stdIn.nextLine();
			try
			{
				numberOfChipsBetInteger = Integer.valueOf(numberOfChipsBetString);
				if ((numberOfChipsBetInteger >= 1) && (numberOfChipsBetInteger <= chipsNow))
				{
					System.out.println("Great! " + numberOfChipsBetString + " chips are on the table.");
					validInput = true;
				}
				else
				{
					System.out.println("I'm so sorry. That is not an integer between 1 and your total number of chips.");
				}
			}
			catch (Exception e)
			{
				System.out.println("I'm sorry. That is not an integer between 1 and your total number of chips.");
			}
		} while (!validInput);
		return numberOfChipsBetString;
	} //end welcome method
		
//**********************************************************************************************************************	
	public static String getNumber(Scanner stdIn)
	{
		String betRequest;
		int betRequestNumber;
		boolean validNumber = false;
		
		do 
		{
			stdIn.reset();
			System.out.print("\rYou previously chose to bet a number. Please let me know what whole number (integer) you would like to bet from 0 through 36:");
			betRequest = stdIn.nextLine();
			try
			{
				betRequestNumber = Integer.valueOf(betRequest);
				if ((betRequestNumber >= 0) && (betRequestNumber <= 36))
				{
					System.out.println("You bet " + betRequestNumber + ".");
					validNumber = true;
				}
				else
				{
					System.out.println("I'm sorry. That is not a number from 0 to 36.");
				}
			}
			catch (Exception e)
			{
				System.out.println("I'm sorry. That is not an integer from 0 to 36.");
			}
		} while (!validNumber);
		return betRequest;
	}
	
//**********************************************************************************************************************	
		public static String getColor(Scanner stdIn)
		{
			String colorChosen;
			int colorChosenAsNumber = 0;
			boolean validColor = false;
			
			do
			{
				stdIn.reset();
				System.out.print("\rPlease enter [1] for black or [2] for red:");
				colorChosen = stdIn.nextLine();
				try
				{
					colorChosenAsNumber = Integer.parseInt(colorChosen);
					if (colorChosenAsNumber == 1) //odd numbers
					{
						System.out.println("You bet black.");
						validColor = true;		
					}
					else if (colorChosenAsNumber == 2) //even numbers
					{
						System.out.println("You bet red."); 
						validColor = true;
					}
					else
					{
						System.out.println("I'm sorry. That is not a 1 or a 2.");
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("I'm sorry. That is not a 1 or a 2.");
				}
			} while (!validColor);
			return colorChosen;
		}
//**********************************************************************************************************************
	public static String spinWheel() //winning number
	{
		System.out.println("\rSpinning the wheel. . .\rThe Wheel of Time turns, and Ages come and pass, leaving memories that become legend.");
		int winningNumber = (int)(Math.random() * 37);
		String winningNumberString = Integer.toString(winningNumber);
		System.out.println(winningNumber + " is the winning number.");
		return winningNumberString;
	}

//**********************************************************************************************************************
	public static String determineColor(String spinNum) //winning color
	{
		String winningColor;
		int winningNumber = Integer.parseInt(spinNum);
		if (winningNumber == 0)
		{
			winningColor = "0"; //for green
			System.out.println("The 0 is green.");
		}
		else if ((winningNumber% 2) == 0) //if winning number is even 
		{
			winningColor = "2"; //for red
			System.out.println("The winning color is red!");
		}
		else 
		{
			winningColor = "1"; //for black
			System.out.println("The winning color is black!");
		}
		return winningColor; 
	}

//**********************************************************************************************************************
	public static int chipsCalculatorNumberBet(int numberOfChipsBet)
	{
		int chipsBetWithWinnings = ((numberOfChipsBet*35) + numberOfChipsBet);
		return chipsBetWithWinnings;
	}
//**********************************************************************************************************************
	public static int chipsCalculatorColorBet(int numberOfChipsBet)
	{
		int chipsBetWithWinnings = (numberOfChipsBet*2);
		return chipsBetWithWinnings;
	}
//**********************************************************************************************************************	
	public static void report(int wins, int losses, int chips)
	{
		int chipDifference = Math.abs((chips - 100));
		System.out.println("\rWins: " + wins);
		System.out.println("Losses: " + losses);
		System.out.println("Initial chip total: 100");
		System.out.println("Current chip total: " + chips);
		
		if (chips < 100)
		{
			System.out.println("I'm sorry. You lost " + chipDifference + " chips since you started with 100.");
		}
		else if (chips > 100)
		{
			System.out.println("You started with 100 chips but now have " + chipDifference + " more chips! Congrats!");
		}
		else if (chips == 100)
		{
			System.out.println("Looks like you came out even!");
		}
		else 
		{
			System.out.println("Final message error");
		}
		System.out.println("\rThank you for playing!");
	}

}//end class
