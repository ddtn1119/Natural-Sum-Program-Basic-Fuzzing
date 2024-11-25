// Name: Andy Nguyen
// Course: CS 4337.502
// Homework 4: Basic Fuzzing
// Generation-Based Fuzzer

public class NaturalSumGenerationFuzzer {
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
    public static int[] GenerationFuzzingTestCases(){
        return new int[]{
            1, 10, 100, // positive numbers
            -1, -10, -100, // negative numbers
            0, // edge case: zero
            1000000, -1000000, // large positive & negative numbers
            Integer.MIN_VALUE, // edge case: minimum integer
            Integer.MAX_VALUE, // edge case: maximum integer
        };
    }
    public static void main(String[] args) {
        int[] test_cases = GenerationFuzzingTestCases();
        
        for(int test_input : test_cases){
            System.out.println("Testing with input: " + test_input);
            try{
                NaturalSum(test_input);
            }
            catch(Exception e){
                System.out.println("Error with input " + test_input + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}