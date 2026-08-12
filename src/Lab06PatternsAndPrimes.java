/*
 * COSC 1173 Programming Lab - Lab 06: Patterns and Primes
 * Textbook reference: Liang, Chapter 5 (Nested Loops, break and continue)
 *
 * Student name: [TYPE YOUR NAME HERE]
 * Date:         [TYPE TODAY'S DATE HERE]
 *
 * REQUIREMENT: every executable statement below must carry a line comment.
 */
import java.util.Scanner;

public class Lab06PatternsAndPrimes {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // creates the keyboard reader

        // PART A - a nested loop that draws a right triangle
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt(); // reads how many rows the triangle should have

        // STEP 1 - TODO: print the single header line   Triangle:   using println.
        //          This matters: the prompt above used print (no newline), so without a
        //          header your first row of asterisks would be appended to the prompt line.

        // STEP 2 - TODO: use a nested loop. The OUTER loop counts the rows (1 through rows).
        //          The INNER loop prints one asterisk per column (1 through the current row
        //          number) with print, and after the inner loop finishes, println() ends the
        //          row. For rows = 4 the output is:
        //              *
        //              **
        //              ***
        //              ****

        // PART B - prime numbers
        System.out.print("Enter the upper limit: ");
        int limit = input.nextInt(); // reads the largest number to test for primality

        // STEP 3 - TODO: print the label "Primes: " with print (NOT println).

        // STEP 4 - TODO: loop over every candidate from 2 through limit. For each candidate,
        //          use an INNER loop to test divisibility by 2 through candidate - 1.
        //          A candidate is prime when no divisor divides it evenly.
        //          Use a boolean flag, and use break to leave the inner loop as soon as a
        //          divisor is found - continuing to test is wasted work.
        //          Print each prime followed by a single space, and count the primes.
        int primeCount = 0; // how many primes have been found so far

        // STEP 5 - TODO: call println() to end the line of primes.

        // STEP 6 - TODO: print   Prime count: 8
        //          For limit = 20 the primes are 2 3 5 7 11 13 17 19, so the count is 8.
    }
}
