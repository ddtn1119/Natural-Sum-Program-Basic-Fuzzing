// Name: Andy Nguyen
// Course: CS 4337.502
// Homework 4: Basic Fuzzing
// Protocol-Based Fuzzer

// generate test cases using inputs of NaturalSum program without prior knowledge of its internal behaviour or implementation
public class NaturalSumProtocolFuzzer {
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
    public static String[] GenerateProtocolBasedTestCases(){
        return new String[]{
            "20", // positive integer
            "-20", // negative integer
            "0", // edge case: zero
            "1000000", // large positive integer
            "-1000000", // small positive integer
            "abc", // non-numeric string
            "20.5", // decimal value
            "", // empty string
            " ", // whitespace
            "9999999999", // overflow
            "-9999999999", // underflow
            String.valueOf(Integer.MIN_VALUE), // edge case: minimum int
            String.valueOf(Integer.MAX_VALUE) // edge case: maximum int
        };
    }
    public static void main(String[] args) {
        String[] test_cases = GenerateProtocolBasedTestCases();
        
        for(String test_input : test_cases){
            System.out.println("Testing with input: " + test_input);
            try{
                int number = Integer.parseInt(test_input);
                NaturalSum(number);
            }
            catch(NumberFormatException nfe){
                System.out.println("Error with input " + test_input + ": non-integer value.");
            }
            catch(Exception e){
                System.out.println("Error with input: " + test_input + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}