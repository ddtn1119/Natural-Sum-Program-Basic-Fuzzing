// Name: Andy Nguyen
// Course: CS 4337.502
// Homework 4: Basic Fuzzing
// Original Code

import java.util.Scanner;
// find the natural sum of a number
public class NaturalSum {
    public static void main(String[] args) {
        System.out.println("Enter a number to find its natural sum:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int sum = 0;
        if(number <= 0){ // if the number is negative
            for(int i=number; i<=0; i++){
                sum += i;
            }
        }
        else{ // if the number is positive
            for(int i=1; i<=number; i++){
                sum += i;
            }
        }
        System.out.println("The natural sum of " + number + " is " + sum);
    }
}