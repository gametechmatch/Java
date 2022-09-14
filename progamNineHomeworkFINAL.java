/*****************************************************************************
 * progamNineHomeworkFINAL.java
 * @author Lily Zimmermann
 * 
 * Semester: Fall 2021
 * 
 * This program emulates a deck of cards. It was an assignment for my intro to 
 * programming Java course. Our assignment had a somewhat loose description of
 * the program requirements so there were some methods we had to code that did not
 * fit in my original structure planned out.
 * 
 * Per our assignment, we were only supposed to be coding a deck of 36 cards to
 * exclude the face cards.
 * 
 * 99 is the placeholder value to catch any errors.
 *****************************************************************************/
import java.util.Scanner;
import java.lang.Math;

public class progamNineHomeworkFINAL
{
	public static void main (String [] args)
	{
		Scanner stdIn = new Scanner(System.in);
		String userPlaying;
		boolean donePlaying = false;
//pre-set variables for coder to adjust for different types of card games and different types of decks	
		int totalCards = 36;
		int totalCardsPerSuit = 9;
		int totalSuits = 4;
		int maximumPlayers = 5;
		int handCardArrayRows; //this program uses two slots for each card so "handCardArrayRows" will always need to be twice the handSize
		int deck[][] = new int [2][totalCards];
//variables that user can adjust for different types of card games		
		int handSize; //"handSize" represents the number of cards each player should be holding in their hands
		int totalPeoplePlaying;

//welcome message
		welcome();
		
		do
		{
			System.out.println("Would you like me to shuffle the deck for a new game?");
			System.out.print("Please enter Y for yes or N for no(to quit): ");
			userPlaying = stdIn.nextLine();	
			System.out.println();
			
			if (userPlaying.equalsIgnoreCase("Y"))
			{
//initialize main deck before game begins	
				deck = initializeDeck(deck, totalCards, totalCardsPerSuit);
				
//shuffle deck	
				shuffleDeck(deck, totalCards);

//ask user how many people are playing and how many total people there are 	
				totalPeoplePlaying = totalPlayers(stdIn, maximumPlayers);
				handSize = handSize(stdIn, totalCards, totalPeoplePlaying);
				handCardArrayRows = (handSize)*2;

//deal out cards 
				int allHands[][] = new int [handCardArrayRows][totalPeoplePlaying]; //this creates a place holder for the values the person will randomly pull
				dealOutCards(allHands, deck, totalPeoplePlaying, handCardArrayRows, handSize); //either also import handSize or handCardArrayRows
				
//print cards dealt
				displayAllHands(allHands, handCardArrayRows, totalPeoplePlaying);
			}
			else if (userPlaying.equalsIgnoreCase("N"))
			{
				System.out.println("GoodBye!");
				donePlaying = true;
			}
			else
			{
				System.out.println("I'm sorry. I don't understand.\r");
			}
		} while (!donePlaying);
		
	} //end main method

//*****************************************************************************	
	//This method prints a welcome message
	public static void welcome()
	{
		System.out.println("*************************************************************************************************");
		System.out.println("****************************************VIRTUAL CARD DECK****************************************");
		System.out.println("*************************************************************************************************");
		System.out.println();
	}
	
//*****************************************************************************	
	//This method initializes a deck
	
	public static int[][] initializeDeck(int[][] deck, int totalCards, int totalCardsPerSuit)
	{
		for (int c = 0; c<totalCards; c++)
		{
			for (int r = 0; r<(2); r++)
			{
				deck[r][c] = cardValue(r, c, totalCardsPerSuit);
			}
		}
		return deck;
	}	
	
//*****************************************************************************	
	//This method returns the integer value ( [1, 9] ) of each card when initializing the deck
		
	public static int cardValue(int row, int column,int totalCardsPerSuit)
	{
		int cardNumber;
		if (row == 0)
		{
			cardNumber = ((column%totalCardsPerSuit)+1);
			return cardNumber;
		}
		else if (row == 1)
		{
			cardNumber = (column/totalCardsPerSuit);
			return cardNumber;
		}	
		System.out.println("Error cardValue");
		return 99; //99 = value used when an error has occurred
	} //end cardValue
	
//*****************************************************************************	
	//This method shuffles the deck by generating 2 random numbers within the index
	//range of the deck array and swapping them
				
	public static void shuffleDeck(int[][] deck, int totalCards)
	{
			
		for (int i = 0; i < (totalCards*3); i ++)
		{
			
		//randomly picking two columns in the deck
		int randomColumn1 = (int)(Math.random()*36);
		int randomColumn2 = (int)(Math.random()*36);

		//making a place holder for the values and suits of the two cards
		int firstCardValue = deck[0][randomColumn1];
		int firstCardSuit = deck[1][randomColumn1];
		int secondCardValue = deck[0][randomColumn2];
		int secondCardSuit = deck[1][randomColumn2];

		//swapping the values
		deck[0][randomColumn1] = secondCardValue;
		deck[1][randomColumn1] = secondCardSuit;
		deck[0][randomColumn2] = firstCardValue;
		deck[1][randomColumn2] = firstCardSuit;
		}
	} //end shuffleDeck	
	
//*****************************************************************************	
	//This method asks the user how many people are playing 
	
	public static int totalPlayers(Scanner stdIn, int maximumPlayers)
	{
		String totalPeopleString;
		int totalPeople;
		boolean validNumber = false;
		System.out.println("This game allows for " + maximumPlayers + " total players maximum.");
		do
		{
			System.out.print("How many people are playing in total?");
			totalPeopleString = stdIn.nextLine();
			if (isNumber(totalPeopleString))
			{
				totalPeople = Integer.parseInt(totalPeopleString);
				if ((totalPeople <= maximumPlayers ) && (totalPeople >= 1 ))
				{
					return totalPeople;
				}
				else
				{
					System.out.println("Sorry. That is not a number from 1 to " + maximumPlayers + ".");
				}
			}
			else
			{
				System.out.println("Sorry. That is not a number from 1 to " + maximumPlayers + ".");
			}
		} while (!validNumber);
		System.out.println("totalPlayers error");
		totalPeople = 99;
		return totalPeople; 
	}

//*****************************************************************************		
	//This method lets a person decide how many cards they want to pull
		
	public static int handSize(Scanner stdIn, int totalCards, int totalPeoplePlaying)
	{
		boolean validNumber = false;
		String handSize;
		int handSizeNumber;
		do
		{
			System.out.println("How many cards should each player have in their hand from 0 to " + (totalCards/totalPeoplePlaying) + " ?");
			handSize = stdIn.nextLine();
			if (isNumber(handSize))
			{
				handSizeNumber = Integer.parseInt(handSize);
				if ((handSizeNumber <= (totalCards/totalPeoplePlaying) ) && (handSizeNumber >= 0 ))
				{
				return handSizeNumber;
				}
				else
				{
					System.out.println("Sorry. That is not a number from 0 to " + (totalCards/totalPeoplePlaying) + ".");
				}
			}
			else
			{
				System.out.println("Sorry. That is not a number from 0 to " + (totalCards/totalPeoplePlaying) + ".");
			}
		} while (!validNumber);
		System.out.println("handSize error");
		handSizeNumber = 99;
		return handSizeNumber;
	} //end handSize
	
//*****************************************************************************	
	//This method verifies if input was a number
		
	private static boolean isNumber(String userInput)
	{
		boolean isNumber;
		for (int i=0; i<userInput.length(); i++)
		{
			if (!Character.isDigit(userInput.charAt(i)))
			{
				isNumber = false;
				return isNumber;
			}
		}	//end for
		return true;
	} //end isNumber

	
//*****************************************************************************	
	
	//This method deals out the cards by filling the allHands array.The algebraic 
	//equation is set up to be able to accurately deal out cards regardless of
	//the number of players or number of cards the user selects.
	
	public static void dealOutCards(int allHands[][], int deck[][], int totalPeoplePlaying, int handCardArrayRows, int handSize)
	{
		for (int player = 0; player < totalPeoplePlaying; player++)
		{
			for (int cardRow= 0; cardRow < (handCardArrayRows); cardRow++)
			{
				int deckRow = determineDeckRows (cardRow);
				int deckColumn = ((player*handSize)+(cardRow/2));
				allHands[cardRow][player] = deck[deckRow][deckColumn];
			}
		}	
	}
	
//*****************************************************************************
	//This method determines the deck array row to pull from while dealing out the cards
	
	private static int determineDeckRows (int cardRow)
	{
		int deckRow;
		if (cardRow%2 == 0)
		{
			deckRow = 0;
			return deckRow;
		}
		else 
		{
			deckRow = 1;
			return deckRow;
		}
	}

//*****************************************************************************	
	//This method prints the cards in all players' hands
	public static void displayAllHands(int [][] allHands, int handCardArrayRows, int totalPeoplePlaying)
	{
			
		for (int c = 0; c<totalPeoplePlaying; c++) //c for columns
		{
			System.out.println("Player " + (c+1));
			for (int r = 0; r<(handCardArrayRows); r++) //r for rows 
			{				
				if (r%2 == 0) //if it is an even numbered row, print the number which is the value
				{
					System.out.print("(" + allHands[r][c]);
				}
				else //if it is an odd numbered row, print a message which is the suit
				{
					cardSuit(allHands,r,c);
				}
			}
			System.out.println();
		}
		System.out.println();
	} //end displayAllHands

//*****************************************************************************	
	//This method returns the suit of the card selected
			
	private static void cardSuit(int [][] allHands, int r,int c)
	{	
		if (allHands[r][c] == 0)
		{
			System.out.print(" of Clubs) ");
		}
		else if (allHands[r][c] == 1)
		{
			System.out.print(" of Spades) ");
		}
		else if (allHands[r][c] == 2)
		{
			System.out.print(" of Hearts) ");
		}
		else if (allHands[r][c] == 3)
		{
			System.out.print(" of Diamonds) ");
		}
		else 
		{
			System.out.println("cardSuit error");
		}
	} //end cardSuit	

//*****************************************************************************	
	//This method prints the card in some reasonable report format.
		
	public static void displayCard(int [][] deck, int row, int column)
	{
		
		System.out.println("You pulled the: " + deck[row][column]);
		cardSuit(deck, row,column);
		
	} //end displayCard
	
//*****************************************************************************	
	//This method prints all the cards from the deck in some reasonable report format
			
	public static void displayDeck(int [][] deck, int totalCards)
	{
		
		for (int c = 0; c<totalCards; c++) //c for columns
		{
			for (int r = 0; r<(2); r++) //r for rows 
			{
				if (r == 0)
				{
					System.out.print(deck[r][c]);
				}
				else if (r ==1)
				{
					if (deck[r][c] == 0)
					{
						System.out.println(" of Clubs");
					}
					else if (deck[r][c] == 1)
					{
						System.out.println(" of Spades");
					}
					else if (deck[r][c] == 2)
					{
						System.out.println(" of Hearts");
					}
					else if (deck[r][c] == 3)
					{
						System.out.println(" of Diamonds");
					}
					else
					{
						System.out.println("displayDeck error");
					}
				}
			}
		}
		System.out.println();
	} //end displayDeck
} //end class
