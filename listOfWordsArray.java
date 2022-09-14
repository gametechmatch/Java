/*****************************************************************************
 * listOfWordsArray.java
 * @author Lily Zimmermann
 * 
 * Semester: Fall 2021
 * 
 * This program maintains a list of words.
 *****************************************************************************/
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class listOfWordsArray
{
	public static void main (String [] args)
	{
		Scanner stdIn = new Scanner(System.in);
		String words[] = new String[50000];
		String word;
		boolean doneAddingWords = false;
		boolean validWord = false;
		int menuChoice;
		int numWords = 0;
		
//beginning of program
		welcome();
		
		do
		{

			menuChoice = getMenuChoice(stdIn);
			
			if (menuChoice == 1) //add word
			{
				System.out.print("What word would you like to add?");
				word = stdIn.nextLine();
				validWord = addWord(words, numWords, word);
				
				if (validWord)
				{
					words [numWords] = word;
					numWords ++;
				}
				else if (!validWord)
				{
					System.out.println("Word was not added.");
				}
				else
				{
					System.out.println("Menu Choice 1 - Add Word Error");
				}
			}
			else if (menuChoice == 2) //remove word
			{
				System.out.print("What word would you like to remove?");
				word = stdIn.nextLine();
				validWord = removeWord(words, numWords, word);
				
				if (validWord)
				{
					int i = findWord(words, numWords, word);
					words[i] = null;
					Arrays.sort(words, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
					numWords --;
					System.out.println("Word was removed.");
				}
				else if (!validWord)
				{
					System.out.println("Word was not removed.");
				}
				else
				{
					System.out.println("Menu Choice 2 - Remove Word Error");
				}
			}
			else if (menuChoice == 3) //print words
			{
				printWords(words, numWords);
			}
			else if (menuChoice == 4) //quit
			{
				System.out.println("Goodbye!");
				doneAddingWords = true;
			}
			else
			{
				System.out.println();
			}
			
		} while (!doneAddingWords);	
	}	//end main
	
//*****************************************************************************
	//This method prints a welcome message
	
	public static void welcome()
	{
		System.out.println("******************************Welcome to WordList!******************************");
		System.out.println();
		
	}	//end welcome
	
//*****************************************************************************
	//This method prints the menu options to the screen, takes in the user�s 
	//selection, and validates it. It returns the valid option selection.
		
	public static int getMenuChoice(Scanner stdIn)
	{
		boolean isValidNumber = false;
		boolean isNumber = false;
		do
		{
			System.out.println("\r1. Add Word");
			System.out.println("2. Remove Word");
			System.out.println("3. Print Words");
			System.out.println("4. Quit");
			System.out.print("\rMenu Selection:");
			String userInput = stdIn.nextLine();
			System.out.println();
			
	//checking if user just pressed enter
			if (userInput == "")
			{
				System.out.println("I'm sorry. I don't understand.");
			}
			else
			{
	//checking if user entered a number
				isNumber = isNumber(userInput);
			
				if (isNumber)
				{
					int menuNumber = Integer.parseInt(userInput);
	//checking if number is within the menu options
					if (menuNumber == 1 || menuNumber == 2 || menuNumber == 3 || menuNumber == 4)
					{
					return menuNumber;
					}
					else
					{
						System.out.println("Sorry. That is not a valid menu choice.");
						return 0;
					}
				}
				else if (!isNumber)
				{
					System.out.println("Sorry. That is not a valid menu choice.");
					return 0;
				}
				else
				{
					System.out.println("Get Menu Choice Method Error 1.");
					return 0;
				}
			}
		} while (!isValidNumber);
		System.out.println("Get Menu Choice Method Error 2.");
		return 0;
	}	//end getMenuChoice
	
//*****************************************************************************	
	//This method verifies if input was a number
			
	private static boolean isNumber(String userInput)
	{
		boolean isNumber = false;
		for (int i=0; i<userInput.length(); i++)
		{
			if (!Character.isDigit(userInput.charAt(i)))
			{
				return false;
			}
		}
		
		isNumber = true;
		return isNumber;
	} //end isNumber
	
//*****************************************************************************
	//This method returns true if user entered a word that can be added, or
	//false if it was not valid input.
	
	public static boolean addWord(String[] words, int numWords, String word)
	{
		boolean validWord = false;
		int wordLocation;

		
	//check if word contains a number
		for (int i=0; i<word.length(); i++)
		{
			if (Character.isDigit(word.charAt(i)))
			{
				System.out.println("That word contains a number. I cannot add it.");
				return validWord;
			}
		}
		
	//check if word contains a space or if user just hit enter
		if (word.contains(" "))
		{
			System.out.println("I'm sorry. That is not a single word.");
			return validWord;
		}
		else if (word.equals(""))
		{
			System.out.println("I'm sorry. It looks like you didn't type anything in.");
			return validWord;
		}
		
	//checking if word is already in list
		wordLocation = findWord(words, numWords, word);
		
		if (wordLocation == ((words.length)+5)) //if you run through list and word was not found
		{
			System.out.println("Word added!");
			validWord = true;
			return validWord;
		}
		else if (wordLocation == ((words.length)+20)) //code to show error occurred
		{
			return validWord;
		}
		else //if the word is already in the list
		{
			System.out.println("I'm sorry that word is alredy in the list of words.");
			return validWord;
		}
	} //end addWord
	
//*****************************************************************************
	//This method returns true if the word entered was found and removed from the array 
	//or false if it was not present in the array.
	
	public static boolean removeWord(String[] words, int numWords, String word)
	{
		boolean validWord = false;
		
		int wordLocation = findWord(words, numWords, word);
		if (wordLocation == ((words.length)+5))
		{
			System.out.println("I'm sorry. I could not find that word to remove.");
			return validWord;
		}
		else if (wordLocation == ((words.length)+20))
		{
			return validWord;
		}
		else
		{
			validWord = true;
			return validWord;
		}
	}	//end removeWord
	
//*****************************************************************************
	//This method first sorts the elements in the words parameter, then prints 
	//them to the screen.
	
	public static void printWords(String[] words, int numWords)
	{
		sort(words, numWords);
		
		if (numWords > 0 )
			{
			System.out.print("{ ");
		    	for (int i = 0; i < numWords; ++i)
		        {
		    		if ((i + 1) == numWords)
		    		{
		    		System.out.print(words[i]);
		    		}
		    		else
		    		System.out.print(words[i] + ", ");
		        }
		    System.out.print(" }"); 
		    }
		else if (numWords == 0)
		{
			System.out.println("I can't print anything. You haven't added any words.");
		}
		else
		{
			System.out.println("Print Words Method Error");
		}
		 
	}	//end printWords
//*****************************************************************************
	//1st method for sorting array - This methods sorts the array
	
	public static void sort(String[] words, int numWords)
	  {
	    int loc;
	    for (int i = 0; i < numWords-1; ++i)
	    {
	      loc = findMin(words, i, numWords-1);
	      swap(words, i, loc);
	    }
	  }
//*****************************************************************************
	//2nd method for sorting array - This method finds the min
	
	public static int findMin(String [] words, int start, int end)
	  {
	    int minSoFarLoc = start;

	    for (int i = start+1; i <= end; ++i)
	    {
	    	//if(list[i].compareTo(list[minIndex]) < 0)
	    	if (words[i].compareTo(words[minSoFarLoc])< 0)
	    	{
	    		minSoFarLoc = i;
	    	}
	    }	    
	    return minSoFarLoc;
	  }
//*****************************************************************************
	//3rd method for sorting array - swap the array values at positions (ind1) and (ind2)
	
		 public static void swap(String[] vals, int ind1, int ind2)
		  {
		    String tmp = vals[ind1];
		    vals[ind1] = vals[ind2];
		    vals[ind2] = tmp;
		  }
//*****************************************************************************
	//This method searches for the word parameter in the words array. If found, 
	//it returns the index of word. If it is able to get to a null space, it
	//enters a number larger than the array size to signal that it is not there.
	
	public static int findWord(String[] words, int numWords, String word)
	{
		for (int i=0; i<(numWords+1); i++)
		{
			if (words[i] == null)
			{
				return ((words.length)+5);
			}
			else if (words[i].equalsIgnoreCase(word))
			{
				return i;
			}
			
			//else
			//{
				//return ((words.length)+10); //number larger than array returned if word is not present
			//}
		}
		System.out.println("Find Word Method Error");
		return ((words.length)+20); //number larger than array returned if an error occurred in this method
	}	//end findWord

}	//end class
