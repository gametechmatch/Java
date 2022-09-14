/*********************************************************************************
 * roomDimensionCalculator.java
 * @author Lily Zimmermann
 * Fall 2021
 *This program prints the dimensions of a room
 ********************************************************************************/

import java.util.Scanner;

public class roomDimensionCalculator
	{
		public static void main(String[] args)
		{
//formatting adding lines in between sections of input
			String programBoxWidthTop = "_________________________________________________________________________________________________________________________________________________________";
			String programBoxWidthMid = "|________________________________________________________________________________________________________________________________________________________";

//introduction & floor length
			Scanner stdIn = new Scanner(System.in); // Create an input scanner for keyboard
			double floorLength;	// Declare celsius variable
			
			System.out.println(programBoxWidthTop);
			System.out.println("|");
			System.out.println("|   Hello!");
			System.out.println("|");
			System.out.println("|\tTrying to paint a wall, redo the floor, or choose a new wallpaper?");
			System.out.println("|\tNo problem! Just enter the measurements and we'll calculate the square footage for you so that your ");
			System.out.println("|\tonly thing to worry is where to put the kitchen sink.");
			System.out.println("|\tLet's start with your floor. What is the length of your floor in feet?");
			System.out.println("|");
			System.out.print("|\tFloor Length(ft): ");
			floorLength = stdIn.nextDouble();
			System.out.println(programBoxWidthMid);

//floor width
			double floorWidth;
			
			System.out.println("|");
			System.out.println("|\tGreat! Now what is the width of your floor in feet?");
			System.out.print("|\tFloor Width(ft): ");
			floorWidth = stdIn.nextDouble();

//FLOOR AREA OUTPUT IN SQUARE FEET
			double floorArea = floorWidth * floorLength;
			String areaMeasurement = "square feet";
			
			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\t\t\tThank you! The area of your floor is: " + floorArea + " " + areaMeasurement);

//floor pun _ \T_T/		\o_o\		/o_o/		\o_o\		/o_o/ 		^_^
			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\tWhat did the feet say to the floor?");
			System.out.println("|\t. . . ");
			System.out.println("|\tI can't stand you anymore!");
			
//north wall width
			double northWallWidth;

			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\tNow let's figure out the area of your walls. What is the width of your north facing wall in feet?");
			System.out.print("|\tNorth Wall Width(ft): ");
			northWallWidth = stdIn.nextDouble();
			
//north wall height
			double northWallHeight;

			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\tAnd the height of your north wall in feet?" + areaMeasurement);
			System.out.print("|\tNorth Wall Height(ft): ");
			northWallHeight = stdIn.nextDouble();


//NORTH WALL AREA IN SQUARE FEET
			double northWallArea = northWallWidth * northWallHeight;

			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\t\t\tThank you! The area of your north wall is: " + northWallArea + " " + areaMeasurement);
			System.out.println(programBoxWidthMid);

//first direction pun, but not the only one
			System.out.println("|");
			System.out.println("|\tWhat is the best way to measure a lawn?");
			System.out.println("|\t. . . ");
			System.out.println("|\tWith a yardstick! ");
			System.out.println(programBoxWidthMid);

//east wall width
			double eastWallWidth;
			
			System.out.println("|");
			System.out.println("|\tSince most rooms aren't just a perfect cube, we're going to go through each wall to make sure");
			System.out.println("|\tthat all your measurement needs are taken care of. What is the width of your east facing wall in feet?");
			System.out.print("|\tEast Wall Width(ft): ");
			eastWallWidth = stdIn.nextDouble();
			
//east wall height
			double eastWallHeight;
			
			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\tThank you. What is the height of your east facing wall in feet?");
			System.out.print("|\tEast Wall Height(ft): ");
			eastWallHeight = stdIn.nextDouble();
			
//EAST WALL AREA IN SQUARE FEET
			double eastWallArea = eastWallWidth * eastWallHeight;

			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\t\t\tThank you! The area of your east wall is: " + eastWallArea + " " + areaMeasurement);
			System.out.println(programBoxWidthMid);

//second direction pun, maybe the last
			System.out.println("|");
			System.out.println("|\tWhat did the Mandalorian say when someone asked him for directions?");
			System.out.println("|\t. . . ");
			System.out.println("|\tThis is the way.");
			System.out.println(programBoxWidthMid);
			
//south wall width
			double southWallWidth;
			
			System.out.println("|");
			System.out.println("|\tWe are almost there. What is the width of your south wall in feet?");
			System.out.print("|\tSouth Wall Width(ft): ");
			southWallWidth = stdIn.nextDouble();
			
//south wall height
			double southWallHeight;
			
			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\tThank you very much! Time to see how high it goes.");
			System.out.print("|\tSouth Wall Height(ft): ");
			southWallHeight = stdIn.nextDouble();
			
//SOUTH WALL AREA IN SQUARE FEET
			double southWallArea = southWallWidth * southWallHeight;

			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\t\t\tThank you! The area of your west wall is: " + southWallArea + " " + areaMeasurement);
			System.out.println(programBoxWidthMid);

//west wall width
			double westWallWidth;
			
			System.out.println("|");
			System.out.println("|\tThere are two things I can't stand. Irony and alliteration. West wall width please.");
			System.out.print("|\tWest Wall Width(ft): ");
			westWallWidth = stdIn.nextDouble();
			
//west wall height
			double westWallHeight;
			
			System.out.println(programBoxWidthMid);
			System.out.println("|\tThank you. Can you guess what I'm going to ask for next?");
			System.out.print("|\tWest Wall Height(ft): ");
			westWallHeight = stdIn.nextDouble();
			
//WEST WALL AREA IN SQUARE FEET
			double westWallArea = westWallWidth * westWallHeight;

			System.out.println(programBoxWidthMid);
			System.out.println("|");
			System.out.println("|\t\t\tThank you! The area of your west wall is: " + westWallArea + " " + areaMeasurement);
			System.out.println(programBoxWidthMid);

//all the dimensions together		
			System.out.println("|");
			System.out.println("|\tYou made it to the end!");
			System.out.println("|");
			System.out.println("|\tAs a reminder, these are the dimensions we figured out:");
			System.out.println("|\tFloor Area: " + floorArea + " " + areaMeasurement);
			System.out.println("|\tNorth Wall Area: " + northWallArea + " " + areaMeasurement);
			System.out.println("|\tEast Wall Area: " + eastWallArea + " " + areaMeasurement);
			System.out.println("|\tSouth Wall Area: " + southWallArea + " " + areaMeasurement);
			System.out.println("|\tWest Wll Area: " + westWallArea + " " + areaMeasurement);
			
//combining calculations
			Double totalWallAreaCalculations = (northWallArea + eastWallArea + southWallArea + westWallArea);
			System.out.println("|");
			System.out.println("|\tYour total wall area is: " + totalWallAreaCalculations + " " + areaMeasurement);
			System.out.println("|\tIf you are looking for paint to cover all walls and the ceiling, then you'll need to plan for: " + (totalWallAreaCalculations + floorArea) + areaMeasurement);
			System.out.println(programBoxWidthMid);
			
		}	//end main
	}	//end class. Thank you!
