/*****************************************************************************
 * diceGame.java
 * @author Lily Zimmermann
 * 
 * Semester: Fall 2021
 * 
 * This program is a game that allows the user to play against the computer by 
 * rolling three six - sided dice each. See game rules below. If the player
 * doesn't enter a "p" to play or a "q" to quit, the computer prompts the 
 * player to try again since the player entered invalid input. After the player
 * asks to quit, the game will output the total wins for the computer, total
 * wins for the player, total ties, and total games played. Depending on 
 * who won or if there was a tie, the computer will print out an appropriate
 * message.
 * 
 * GAME RULES
 * You can get a triple, a double, or 
 * trash. A triple is when 3 dice match. A double is when 2 dice match, and 
 * trash is when none of the dice match. If both the computer and player get
 * a double, the winner is the one with the higher value pair. If the pairs
 * match, then the winner is the one with the higher remaining die value. If
 * both the player and computer have triples, then the winner comes down to
 * the higher value triple. If the triples match, then they tie. If they both
 * have trash then they tie.
 *****************************************************************************/
import java.lang.Math;
import java.util.Scanner;

public class diceGame
{
	public static void main (String [] args)
	{
		Scanner stdIn = new Scanner(System.in);
		boolean yesPlaying = true;
		
		String playingAnotherRound;
		int numberOfGames = 0;
		
		int playerNumberOfWins = 0;
		int computerNumberOfWins = 0;
		int numberOfTies = 0;
		
		//player's dice
		int pD1;
		int pD2;
		int pD3;
		
		//computer's dice
		int cD1;
		int cD2;
		int cD3;

		System.out.println("Hello! Let's play a game. You get 3 dice and I get 3 dice. Each dice has 6 sides with numbers from 1 through 6.");
		System.out.println("You can get a triple, a pair, or junk. Triples are greater than pairs and triples and pairs are both better than junk.");
		System.out.println("If we both get a pair or a triple, then it comes down to the higher number that is matching. Want to play?");
		do
			{
			System.out.print("Please enter the letter p to play a round or q to quit.");
			playingAnotherRound = stdIn.nextLine();
			
			if (playingAnotherRound.equalsIgnoreCase("p"))
			{
				pD1 = (int)(Math.random() * 6) + 1;
				pD2 = (int)(Math.random() * 6) + 1;
				pD3 = (int)(Math.random() * 6) + 1;
				
				System.out.println("\rYour three dice are: " + pD1 + ", " + pD2 + ", and " + pD3 + ".");
				System.out.println("\rNow it's my turn!");
				
				cD1 = (int)(Math.random() * 6) + 1;
				cD2 = (int)(Math.random() * 6) + 1;
				cD3 = (int)(Math.random() * 6) + 1;
				
				System.out.println("My three dice are: " + cD1 + ", " + cD2 + ", and " + cD3 + ".");
				
				if ( (pD1 == pD2 && pD1 == pD3) || (cD1 == cD2 && cD1 == cD3))
				{
					//if both have triples
					if ( (pD1 == pD2 && pD1 == pD3) && (cD1 == cD2 && cD1 == cD3))
					{
						//if they both have triples and the player wins
						if (( (pD1 == pD2 && cD1 == cD2) && (pD1 > cD1) ) || 
							( (pD1 == pD2 && cD2 == cD3) && (pD1 > cD2) ) ||
							( (pD2 == pD3 && cD1 == cD2) && (pD2 > cD1) ) ||
							( (pD2 == pD3 && cD2 == cD3) && (pD2 > cD2) ))
						{
							playerNumberOfWins++;
							numberOfGames++;
							System.out.println("We both got triples, but your triple is higher so you win.");
						}
						//if they both have triples and the computer wins
						else if (( (pD1 == pD2 && cD1 == cD2) && (cD1 > pD1) ) || 
								 ( (pD1 == pD2 && cD2 == cD3) && (cD1 > pD2) ) ||
								 ( (pD2 == pD3 && cD1 == cD2) && (cD2 > pD1) ) ||
								 ( (pD2 == pD3 && cD2 == cD3) && (cD2 > pD2) ))
						{
							computerNumberOfWins++;
							numberOfGames++;
							System.out.println("We both got triples, but my triple is higher so I win.");
						}
						//if they both have triples but tie
						else
						{
							numberOfTies++;
							numberOfGames++;
							System.out.println("We have equal triples, so we tie!");
						}
					}
					//if only the player gets a triple
					else if ((pD1 == pD2 && pD1 == pD3) && (cD1 != cD2 && cD1 != cD3))
					{
						playerNumberOfWins++;
						numberOfGames++;
						System.out.println("You got a triple! I only got junk, so you win this round.");
					}
					//if only the computer gets a triple
					else
					{
						computerNumberOfWins++;
						numberOfGames++;
						System.out.println("I got a triple! Unfortunately, you only got junk so I win this round.");
					}
				}
//if any roll a double
				else if ((pD1 == pD2 || pD1 == pD3 || pD2 == pD3) || (cD1 == cD2 || cD1 == cD3 || cD2 == cD3))
				{
					//if both get a double
					if ((pD1 == pD2 || pD1 == pD3 || pD2 == pD3) && (cD1 == cD2 || cD1 == cD3 || cD2 == cD3))
					{
						//if they both get a double but the player wins from having a higher double
						if (	( (pD1 == pD2) && (cD1 == cD2) && (pD1 > cD1) ) ||
								( (pD1 == pD2) && (cD2 == cD3) && (pD1 > cD2) ) ||
								( (pD1 == pD2) && (cD1 == cD3) && (pD1 > cD3) ) ||
							
								( (pD1 == pD3) && (cD1 == cD2) && (pD1 > cD1) ) ||
								( (pD1 == pD3) && (cD2 == cD3) && (pD1 > cD2) ) ||
								( (pD1 == pD3) && (cD1 == cD3) && (pD1 > cD3) ) ||
							
								( (pD2 == pD3) && (cD1 == cD2) && (pD2 > cD1) ) ||
								( (pD2 == pD3) && (cD2 == cD3) && (pD2 > cD2) )	||
								( (pD2 == pD3) && (cD1 == cD3) && (pD2 > cD3) ))
							{
								playerNumberOfWins++;
								numberOfGames++;
								System.out.println("We both got doubles, but yours is higher so you win!");
							}
						//if they both get a double but the computer wins from having a higher double
						else if (( (pD1 == pD2) && (cD1 == cD2) && (pD1 < cD1) ) ||
								( (pD1 == pD2) && (cD2 == cD3) && (pD1 < cD2) ) ||
								( (pD1 == pD2) && (cD1 == cD3) && (pD1 < cD3) ) ||
								
								( (pD1 == pD3) && (cD1 == cD2) && (pD1 < cD1) ) ||
								( (pD1 == pD3) && (cD2 == cD3) && (pD1 < cD2) ) ||
								( (pD1 == pD3) && (cD1 == cD3) && (pD1 < cD3) ) ||
								
								( (pD2 == pD3) && (cD1 == cD2) && (pD2 < cD1) ) ||
								( (pD2 == pD3) && (cD2 == cD3) && (pD2 < cD2) )	||
								( (pD2 == pD3) && (cD1 == cD3) && (pD2 < cD3) ))
							{
								computerNumberOfWins++;
								numberOfGames++;
								System.out.println("We both got doubles, but mine is higher so I win.");
							}
						//if they both get a double, have the same double, but the player wins from having the higher left over die
						else if (	( (pD1 == pD2) && (cD1 == cD2) && (pD1 == cD1) && (pD3 > cD3) ) ||
								( (pD1 == pD2) && (cD2 == cD3) && (pD1 == cD2) && (pD3 > cD1) ) ||
								( (pD1 == pD2) && (cD1 == cD3) && (pD1 == cD3) && (pD3 > cD2) ) ||
							
								( (pD1 == pD3) && (cD1 == cD2) && (pD1 == cD1) && (pD2 > cD3) ) ||
								( (pD1 == pD3) && (cD2 == cD3) && (pD1 == cD2) && (pD2 > cD1) ) ||
								( (pD1 == pD3) && (cD1 == cD3) && (pD1 == cD3) && (pD2 > cD2) ) ||
							
								( (pD2 == pD3) && (cD1 == cD2) && (pD2 == cD1) && (pD1 > cD3) ) ||
								( (pD2 == pD3) && (cD2 == cD3) && (pD2 == cD2) && (pD1 > cD1) )	||
								( (pD2 == pD3) && (cD1 == cD3) && (pD2 == cD3) && (pD1 > cD2) ))
							{
								playerNumberOfWins++;
								numberOfGames++;
								System.out.println("We both got the same double, but your extra is higher so you win!");
							}
						//if they both get a double, have the same double, but the computer wins from having the higher left over die
						else if (( (pD1 == pD2) && (cD1 == cD2) && (pD1 == cD1) && (pD3 < cD3) ) ||
								( (pD1 == pD2) && (cD2 == cD3) && (pD1 == cD2) && (pD3 < cD1) ) ||
								( (pD1 == pD2) && (cD1 == cD3) && (pD1 == cD3) && (pD3 < cD2) ) ||
							
								( (pD1 == pD3) && (cD1 == cD2) && (pD1 == cD1) && (pD2 < cD3) ) ||
								( (pD1 == pD3) && (cD2 == cD3) && (pD1 == cD2) && (pD2 < cD1) ) ||
								( (pD1 == pD3) && (cD1 == cD3) && (pD1 == cD3) && (pD2 < cD2) ) ||
							
								( (pD2 == pD3) && (cD1 == cD2) && (pD2 == cD1) && (pD1 < cD3) ) ||
								( (pD2 == pD3) && (cD2 == cD3) && (pD2 == cD2) && (pD1 < cD1) )	||
								( (pD2 == pD3) && (cD1 == cD3) && (pD2 == cD3) && (pD1 < cD2) ))
							{
								computerNumberOfWins++;
								numberOfGames++;
								System.out.println("We both got the same double, but my extra is higher so I win!");
							}
						//if they tie because the double and the left over die both match
						else
						{
							numberOfTies++;
							numberOfGames++;
							System.out.println("We both have equal doubles, so we tie!");
						}
					}
					//if only the player gets a double
					else if ((pD1 == pD2 || pD1 == pD3 || pD2 == pD3) && (cD1 != cD2 && cD1 != cD3 && cD2 != cD3))
					{
						playerNumberOfWins++;
						numberOfGames++;
						System.out.println("You got a double! I only got junk, so you win this round.");
					}
					//if only the computer gets a double
					else 
					{
						computerNumberOfWins++;
						numberOfGames++;
						System.out.println("I got a double! Unfortunately, you only got junk so I win this round.");
					}
				}
//if any roll a triple
				
//if both have trash
				else
				{
					numberOfTies++;
					numberOfGames++;
					System.out.println("I'm afraid we both got trash, so we tied.");
				}
			} //end "playing" loop
			else if (playingAnotherRound.equalsIgnoreCase("q"))
			{
				yesPlaying = false;
			} //end "done playing" loop
			else
			{
				System.out.println("I'm sorry. I couldn't understand that.");
			} //end invalid input loop
			} while (yesPlaying); //end playing loop
		
		System.out.println("\rThanks for playing today!");
		System.out.println("In total, we played " + numberOfGames + " total game(s).");
		System.out.println("\rYou won " + playerNumberOfWins + " time(s) while I won " + computerNumberOfWins + " time(s). We tied " + numberOfTies + " time(s).");
		
		if (computerNumberOfWins > playerNumberOfWins)
		{
			System.out.println("You lost overall. Oh well. Better luck next time.");
		}
		else if (computerNumberOfWins == playerNumberOfWins)
		{
			System.out.println("Wow, we tied overall! You really put me on my toes!");
		}
		else
		{
			System.out.println("You won overall! Great job!");
		}
	}	//end main
}	//end class
