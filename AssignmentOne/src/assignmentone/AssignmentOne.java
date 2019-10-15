/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone;

import java.util.Scanner;

/**
 *
 * @author mauri
 */
public class AssignmentOne 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //call 3 functions
        comparison();
        forLoop();
        whileSwitch();
    }

    private static void comparison() 
    {
        //instantiate and instance of class Scanner,
        Scanner input = new Scanner(System.in);
        
        int number1;
        int number2;
        
        //user input and store value
        System.out.println("Enter first integer: ");
        number1 = input.nextInt();
        System.out.println("Enter second integer: ");
        number2 = input.nextInt();
        
        //Using the comparison operators
        if(number1 == number2)
            System.out.printf("%d == %d\n", number1, number2);
        if(number1 != number2)
            System.out.printf("%d != %d\n", number1, number2);
        if(number1 < number2)
            System.out.printf("%d < %d\n", number1, number2);
        if(number1 > number2)
            System.out.printf("%d > %d\n", number1, number2);
        if(number1 <= number2)
            System.out.printf("%d <= %d\n", number1, number2);
        if(number1 >= number2)
            System.out.printf("%d >= %d\n", number1, number2);
        
    }

    private static void forLoop() 
    {
        double amount = 0;
        double principle; 
        double rate;
        double time;
        double ci;
        double t = 1;
        
        Scanner input = new Scanner(System.in);
        
        //user input and store value
        System.out.println("Enter initial principle");
        principle = input.nextDouble();
        System.out.println("Enter interest rate");
        rate = input.nextDouble();
        System.out.println("Enter investment years");
        time = input.nextDouble();
        
        //update value
        rate = ( 1 + rate / 100);
        
        //for loop
        for(int i = 0; i < time; i++)
            t = t * rate;
        
        //calculate compound interest
        amount = principle * t;
        System.out.println("Amount = " + amount);
        ci = amount - principle;
        System.out.println("Compound interest = " + ci);
    }

    private static void whileSwitch() 
    {
        int day = 0;
        int rain = 0;
        
        //while loop for 7 days
        while(day <= 7)
        {
            //switch block of rain
            switch (day)
            {
                case 0:
                    System.out.println("Sunday we got 1 inch of rain");
                    rain += 1;
                    break;
                case 1:
                    System.out.println("Monday we got 2 inch of rain");
                    rain += 2;
                    break;
                case 2:
                    System.out.println("Tuesday we got 3 inch of rain");
                    rain += 3;
                    break;
                case 3:
                    System.out.println("Wednesday we got 4 inch of rain");
                    rain += 4;
                    break;
                case 4:
                    System.out.println("Thursday we got 5 inch of rain");
                    rain += 5;
                    break;
                case 5:
                    System.out.println("Friday we got 6 inch of rain");
                    rain += 6;
                    break;
                case 6:
                    System.out.println("Saturday we got 7 inch of rain");
                    rain += 7;
                    break;
                default:
            }
            day++;
        }
        //rain received in past week output
        System.out.println("We got 28 inches of rain this week! Please stop raining");
    }


    
}
