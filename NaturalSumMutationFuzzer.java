// Name: Andy Nguyen
// Course: CS 4337.502
// Homework 4: Basic Fuzzing
// Mutation-Based Fuzzer

import java.util.Random;

public class NaturalSumMutationFuzzer {
    // method to generate mutated test inputs
    // taking existing integers & mutating them to generate new test cases
    public static int GenerateTestInputs(){
        Random r = new Random();
        int num = r.nextInt(5);
        switch(num){
            case 0: return 0;
            case 1: return r.nextInt(1000); // random positive number
            case 2: return -r.nextInt(1000); // random negative number
            case 3: return Integer.MAX_VALUE; // edge case: maximum integer
            case 4: return Integer.MIN_VALUE; // edge case: minimum value
            default: return r.nextInt(); // return any random integer by default
        }
    }
    
    public static void NaturalSum(int number){
        // copy the logic of the original NaturalSum program
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
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            int test_input = GenerateTestInputs();
            System.out.println("Testing with input: " + test_input);
            try {
                NaturalSum(test_input);
            }
            catch (Exception e){
                System.out.println("Error with input " + test_input + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}