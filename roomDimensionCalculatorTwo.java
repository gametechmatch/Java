/****************************************************************************************************************************************
 * roomDimensionCalculatorTwo.java
 * Program Nickname: 	The Matryoshka Dimensions
 * Author: Lily Zimmermann
 *********************************************************************************************
 * Fall 2021
 *What Program Does: 	This program prints the dimensions of a room
 ****************************************Program Notes:****************************************
 *In order to stop the program from malfunctioning if the user types in anything other than a number, an error message was created. The
 *		first part of the error message is if the user properly enters a number. The second part of the error message is if the user
 *		enters anything other then a number, prompting the user to apply a number this time.
 *
 ********************************************INDEX********************************************
 *____________GENERAL CODE____________
 *Variables		Lines 26 - 36
 *
 *____________MESSAGE SECTIONS____________
 *A. Floor
 *		1. Floor Length
 *		2. Floor Width
 *		3. Floor Area
 *
 *B. North Wall
 *		1. North Wall Length
 *		2. North Wall Height
 *		3. North Wall Area
 *
 *C. East Wall
 *		1. East Wall Length
 *		2. East Wall Height
 *		3. East Wall Area
 *
 *D. South Wall
 *		1. South Wall Length
 *		2. South Wall Height
 *		3. South Wall Area
 *
 *E. West Wall
 *		1. West Wall Length
 *		2. West Wall Height
 *		3. West Wall Area
 *
 *F. Final Calculations
 *
 ****************************************************************************************************************************************/

import java.util.Scanner;	//1st part of code that allows input

public class roomDimensionCalculatorTwo
	{
		public static void main(String[] args)
		{
/****************************************************************************************************************************************
 *Variable Section 
 ****************************************************************************************************************************************/
//Formatting variables
			String programBoxWidthTop;
			String programBoxWidthMid;

			programBoxWidthTop = "_________________________________________________________________________________________________________________________________________________________";
			programBoxWidthMid = "|________________________________________________________________________________________________________________________________________________________";
//Error message variables
			String errorMessage;

			errorMessage = ("|\tI'm sorry. I only can process numbers.\r" + "|\r" + programBoxWidthMid  + "\r" +	"|\r");
/****************************************************************************************************************************************
 *Additional coding for input
 ****************************************************************************************************************************************/
			Scanner stdIn = new Scanner(System.in);	//2nd part of code that allows input
/****************************************************************************************************************************************
*Section A___Start
****************************************************************************************************************************************/
//Start Section A.1.___Intro & Floor Length
			double floorLength;
			boolean isNumber;

			System.out.println(programBoxWidthTop);
			System.out.println("|");
			System.out.println("|   Hello!");
			System.out.println("|");
			System.out.println("|\tTrying to paint a wall, redo the floor, or choose a new wallpaper?");
			System.out.println("|\tNo problem! Just enter the measurements and we'll calculate the square footage for you so that your ");
			System.out.println("|\tonly thing to worry is where to put the kitchen sink.");
			System.out.println("|\tLet's start with your floor. What is the length of your floor in feet?");
			System.out.println("|");
		//ERROR MESSAGE___Floor Length___1st part (if client enters number, this half of the error message progresses the program forward)
			do
			{
				System.out.print("|\tFloor Length(ft): ");
				if (stdIn.hasNextDouble())
				{
					floorLength = stdIn.nextDouble();
					isNumber = true;
//Start Section A.2.___Floor Width
						double floorWidth;

						System.out.println("|");
						System.out.println("|\tGreat! Now what is the width of your floor in feet?");
		//ERROR MESSAGE _ Floor Width _1st part (if client enters number, this half of the error message progresses the program forward)
						do
						{
							System.out.print("|\tFloor Width(ft): ");
							if (stdIn.hasNextDouble())
							{
								floorWidth = stdIn.nextDouble();
								isNumber = true;
//Start Section A.3.___FLOOR AREA OUTPUT
									double floorArea;
									floorArea = floorLength * floorWidth;
									String areaMeasurement = "square feet";

									System.out.println(programBoxWidthMid);
									System.out.println("|");
									System.out.println("|\t\t\tThank you! The area of your floor is: " + floorArea + " " + areaMeasurement);
//End Section A.3.___FLOOR AREA OUTPUT
//Start___Floor Pun___\T_T/___\o_o\___/o_o/___\o_o\___/o_o/___^_^
									System.out.println(programBoxWidthMid);
									System.out.println("|");
									System.out.println("|\tWhat did the feet say to the floor?");
									System.out.println("|\t. . . ");
									System.out.println("|\tI can't stand you anymore!");
//End___Floor Pun
/****************************************************************************************************************************************
*Section B___Start
****************************************************************************************************************************************/
//Start Section B.1.___North Wall Width
									double northWallWidth;

									System.out.println(programBoxWidthMid);
									System.out.println("|");
									System.out.println("|\tNow let's figure out the area of your walls. What is the width of your north facing wall in feet?");
		//ERROR MESSAGE___North Wall Width___1st part (if client enters number, this half of the error message progresses the program forward)
									do
									{
										System.out.print("|\tNorth Wall Width(ft): ");
										if (stdIn.hasNextDouble())
										{
											northWallWidth = stdIn.nextDouble();
											isNumber = true;
//Start Section B.2.___North Wall Height
											double northWallHeight;

											System.out.println(programBoxWidthMid);
											System.out.println("|");
											System.out.println("|\tAnd the height of your north wall in feet?" + areaMeasurement);
		//ERROR MESSAGE___North Wall Height___1st part (if client enters number, this half of the error message progresses the program forward)
											do
											{
												System.out.print("|\tNorth Wall Height(ft): ");
												if (stdIn.hasNextDouble())
												{
													northWallHeight = stdIn.nextDouble();
													isNumber = true;
//Start Section B.3.___North Wall Area
													double northWallArea = northWallWidth * northWallHeight;

													System.out.println(programBoxWidthMid);
													System.out.println("|");
													System.out.println("|\t\t\tThank you! The area of your north wall is: " + northWallArea + " " + areaMeasurement);
													System.out.println(programBoxWidthMid);
//End Section B.3.___North Wall Area
//Start___Direction Pun___but not the only one
													System.out.println("|");
													System.out.println("|\tWhat is the best way to measure a lawn?");
													System.out.println("|\t. . . ");
													System.out.println("|\tWith a yardstick! ");
													System.out.println(programBoxWidthMid);
//End___Direction Pun
/****************************************************************************************************************************************
*Section C___Start
****************************************************************************************************************************************/
//Start Section C.1.___East Wall Width
													double eastWallWidth;

													System.out.println("|");
													System.out.println("|\tSince most rooms aren't just a perfect cube, we're going to go through each wall to make sure");
													System.out.println("|\tthat all your measurement needs are taken care of. What is the width of your east facing wall in feet?");
		//ERROR MESSAGE___East Wall Width___1st part (if client enters number, this half of the error message progresses the program forward)
													do
													{
														System.out.print("|\tEast Wall Width(ft): ");
														if (stdIn.hasNextDouble())
														{
															eastWallWidth = stdIn.nextDouble();
															isNumber = true;
//Start Section C.2.___East Wall Height
															double eastWallHeight;

															System.out.println(programBoxWidthMid);
															System.out.println("|");
															System.out.println("|\tThank you. What is the height of your east facing wall in feet?");
		//ERROR MESSAGE___East Wall Height___1st part (if client enters number, this half of the error message progresses the program forward)
															do
															{
																System.out.print("|\tEast Wall Height(ft): ");
																if (stdIn.hasNextDouble())
																{
																	eastWallHeight = stdIn.nextDouble();
																	isNumber = true;
//Start Section C.3.___East Wall Area
																	double eastWallArea = eastWallWidth * eastWallHeight;

																	System.out.println(programBoxWidthMid);
																	System.out.println("|");
																	System.out.println("|\t\t\tThank you! The area of your east wall is: " + eastWallArea + " " + areaMeasurement);
																	System.out.println(programBoxWidthMid);
//End Section C.3.___East Wall Area
//Start___Second Direction Pun___Maybe the last
																	System.out.println("|");
																	System.out.println("|\tWhat did the Mandalorian say when someone asked him for directions?");
																	System.out.println("|\t. . . ");
																	System.out.println("|\tThis is the way.");
																	System.out.println(programBoxWidthMid);
//End___Second Direction Pun
/****************************************************************************************************************************************
*Section D___Start
****************************************************************************************************************************************/
//Start Section D.1.___South Wall Width
																	double southWallWidth;

																	System.out.println("|");
																	System.out.println("|\tWe are almost there. What is the width of your south wall in feet?");
		//ERROR MESSAGE___South Wall Width___1st part (if client enters number, this half of the error message progresses the program forward)
																	do
																	{
																		System.out.print("|\tSouth Wall Width(ft): ");
																		if (stdIn.hasNextDouble())
																		{
																			southWallWidth = stdIn.nextDouble();
																			isNumber = true;
//Start Section D.2.___South Wall Height
																			double southWallHeight;

																			System.out.println(programBoxWidthMid);
																			System.out.println("|");
																			System.out.println("|\tThank you very much! Time to see how high it goes.");
		//ERROR MESSAGE___South Wall Height___1st part (if client enters number, this half of the error message progresses the program forward)
																			do
																			{
																				System.out.print("|\tSouth Wall Height(ft): ");
																				if (stdIn.hasNextDouble())
																				{
																					southWallHeight = stdIn.nextDouble();
																					isNumber = true;
//Start Section D.3.___South Wall Area
																					double southWallArea = southWallWidth * southWallHeight;

																					System.out.println(programBoxWidthMid);
																					System.out.println("|");
																					System.out.println("|\t\t\tThank you! The area of your west wall is: " + southWallArea + " " + areaMeasurement);
																					System.out.println(programBoxWidthMid);
//End Section D.3.___South Wall Area
/****************************************************************************************************************************************
*Section E___Start
****************************************************************************************************************************************/
//Start Section E.1.___West Wall Width
																					double westWallWidth;

																					System.out.println("|");
																					System.out.println("|\tThere are two things I can't stand. Irony and alliteration. West wall width please.");
			//ERROR MESSAGE___West Wall Width___1st part (if client enters number, this half of the error message progresses the program forward)
																					do
																					{
																						System.out.print("|\tWest Wall Width(ft): ");
																						if (stdIn.hasNextDouble())
																						{
																							westWallWidth = stdIn.nextDouble();
																							isNumber = true;
//Start Section E.2.___West Wall Height
																							double westWallHeight;

																							System.out.println(programBoxWidthMid);
																							System.out.println("|\tThank you. Can you guess what I'm going to ask for next?");
			//ERROR MESSAGE___West Wall Height___1st part (if client enters number, this half of the error message progresses the program forward)
																							do
																							{
																								System.out.print("|\tWest Wall Height(ft): ");
																								if (stdIn.hasNextDouble())
																								{
																									westWallHeight = stdIn.nextDouble();
																									isNumber = true;
//Start Section E.3.___West Wall Area
																									double westWallArea = westWallWidth * westWallHeight;

																									System.out.println(programBoxWidthMid);
																									System.out.println("|");
																									System.out.println("|\t\t\tThank you! The area of your west wall is: " + westWallArea + " " + areaMeasurement);
																									System.out.println(programBoxWidthMid);
//End Section E.3.___West Wall Area
/****************************************************************************************************************************************
*Section F___Start
****************************************************************************************************************************************/
//Start Section F.1.___Final Calculations
																									System.out.println("|");
																									System.out.println("|\tYou made it to the end!");
																									System.out.println("|");
																									System.out.println("|\tAs a reminder, these are the dimensions we figured out:");
																									System.out.println("|\tFloor Area: " + floorArea + " " + areaMeasurement);
																									System.out.println("|\tNorth Wall Area: " + northWallArea + " " + areaMeasurement);
																									System.out.println("|\tEast Wall Area: " + eastWallArea + " " + areaMeasurement);
																									System.out.println("|\tSouth Wall Area: " + southWallArea + " " + areaMeasurement);
																									System.out.println("|\tWest Wll Area: " + westWallArea + " " + areaMeasurement);

																									Double totalWallAreaCalculations = (northWallArea + eastWallArea + southWallArea + westWallArea);
																									System.out.println("|");
																									System.out.println("|\tYour total wall area is: " + totalWallAreaCalculations + " " + areaMeasurement);
																									System.out.println("|\tIf you are looking for paint to cover all walls and the ceiling, then you'll need to plan for: " + (totalWallAreaCalculations + floorArea) + areaMeasurement);
																									System.out.println(programBoxWidthMid);
//End Section F.1.___Final Calculations
/****************************************************************************************************************************************
*Section F___End
****************************************************************************************************************************************/
			//ERROR MESSAGE___West Wall Height___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
																								}
																								else
																								{
																									System.out.println(programBoxWidthMid);
																									System.out.println("|");
																									System.out.print(errorMessage);
																									isNumber = false;
																									stdIn.next();
																								}
																							}
																							while (!(isNumber));
//End Section E.2.___West Wall Height
			//ERROR MESSAGE___West Wall Width___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
																						}
																						else
																						{
																							System.out.println(programBoxWidthMid);
																							System.out.println("|");
																							System.out.print(errorMessage);
																							isNumber = false;
																							stdIn.next();
																						}
																					}
																					while (!(isNumber));
//End Section E.1.___West Wall Width
/****************************************************************************************************************************************
*Section E___End
****************************************************************************************************************************************/
		//ERROR MESSAGE___South Wall Height___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
																				}
																				else
																				{
																					System.out.println(programBoxWidthMid);
																					System.out.println("|");
																					System.out.print(errorMessage);
																					isNumber = false;
																					stdIn.next();
																				}
																			}
																			while (!(isNumber));
//End Section D.2.___South Wall Height
		//ERROR MESSAGE___South Wall Width___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
																		}
																		else
																		{
																			System.out.println(programBoxWidthMid);
																			System.out.println("|");
																			System.out.print(errorMessage);
																			isNumber = false;
																			stdIn.next();
																		}
																	}
																	while (!(isNumber));
//End Section D.1.___South Wall Width
/****************************************************************************************************************************************
*Section D___End
****************************************************************************************************************************************/
		//ERROR MESSAGE___East Wall Width___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
																}
																else
																{
																	System.out.println(programBoxWidthMid);
																	System.out.println("|");
																	System.out.print(errorMessage);
																	isNumber = false;
																	stdIn.next();
																}
															}
															while (!(isNumber));
//End Section C.2.___East Wall Height
		//ERROR MESSAGE___East Wall Width___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
														}
														else
														{
															System.out.println(programBoxWidthMid);
															System.out.println("|");
															System.out.print(errorMessage);
															isNumber = false;
															stdIn.next();
														}
													}
													while (!(isNumber));
//End Section C.1.___East Wall Width
/****************************************************************************************************************************************
*Section C___End
****************************************************************************************************************************************/
		//ERROR MESSAGE___North Wall Height___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
												}
												else
												{
													System.out.println(programBoxWidthMid);
													System.out.println("|");
													System.out.print(errorMessage);
													isNumber = false;
													stdIn.next();
												}
											}
											while (!(isNumber));
//End Section B.2.___North Wall Height
		//ERROR MESSAGE___North Wall Width___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
										}
										else
										{
											System.out.println(programBoxWidthMid);
											System.out.println("|");
											System.out.print(errorMessage);
											isNumber = false;
											stdIn.next();
										}
									}
									while (!(isNumber));
//End Section B.1.___North Wall Width
/****************************************************************************************************************************************
*Section B___End
****************************************************************************************************************************************/
		//ERROR MESSAGE___Floor Width___2nd Part___(if client enters anything other than a number, this will ask them again for a number)
							}
							else
							{
								System.out.println(programBoxWidthMid);
								System.out.println("|");
								System.out.print(errorMessage);
								isNumber = false;
								stdIn.next();
							}
						}
						while (!(isNumber));
//End Section A.2.___Floor Width
		//ERROR MESSAGE_Floor Length_2nd Part_ (if client enters anything other than a number, this will ask them again for a number)
				}
				else
				{
					System.out.println(programBoxWidthMid);
					System.out.println("|");
					System.out.print(errorMessage);
					isNumber = false;
					stdIn.next();
				}
			}
			while (!(isNumber));
//End Section A.1.___Floor Length
/****************************************************************************************************************************************
*Section A___End
****************************************************************************************************************************************/
			}	//end class. Thank you!
		}	//end main
