/*
TempConverter.java
******************************************************************************************
Author: gametechmatch
Date: 2/3/2023
Course: Object Oriented Programming 1
Semester: Spring 2023
Assingment: PP2.5
******************************************************************************************
This program uses functional programming to convert user input degrees from Fahrenheit to Celsius.
 */
package tempconverter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TempConverter 
{
    public static void main(String[] args) 
    {
        Scanner stdIn = new Scanner(System.in);
         
        // Declare variables
        final int BASE = 32; 
        final double CONVERSION_FACTOR = 5.0 / 9.0;
        double fahrenheitTempNum = 0;
        boolean waitingForValidInput = true;
        DecimalFormat df = new DecimalFormat("#.##");
        
        // Get valid input
        fahrenheitTempNum = getValidInputTemp(fahrenheitTempNum,stdIn);
        
        // Calculate degrees Celsius & print result
        calculateTemperature(fahrenheitTempNum,BASE,CONVERSION_FACTOR,df);
        
    } //end main

//******************************************************************************************
    // This method gets valid input from the user to get the degrees Fahrenheit
    public static double getValidInputTemp(double fahrenheitTempNum, Scanner stdIn)
    {
        String fahrenheitTemp;
        while(fahrenheitTempNum == 0)
        {
            System.out.print("Please enter degrees in Fahrenheit: ");
            fahrenheitTemp = stdIn.nextLine(); 
            
            // Try to convert string input into a double, redo loop if input invalid
            try
            {
                fahrenheitTempNum = Double.valueOf(fahrenheitTemp);
            }
            catch (NumberFormatException e)
            {
                fahrenheitTempNum = 0;
                System.out.println("Please enter a number");
            }
        }
        return fahrenheitTempNum;
    } // end getValidInputTemp

//*****************************************************************************************
    // This method calculates the Fahrenheit temp provided by user into degrees Celsius
    public static void calculateTemperature(double fahrenheitTempNum, 
            int BASE, final double CONVERSION_FACTOR, DecimalFormat df)
    {
        double celsiusTemp;
        
        celsiusTemp = (fahrenheitTempNum - BASE) * CONVERSION_FACTOR; 
        System.out.println("\nFahrenheit Temperature: " + fahrenheitTempNum);
        System.out.print("Celsius Equivalent: " + df.format(celsiusTemp));
    } // end calculateTemperature
} //end class
