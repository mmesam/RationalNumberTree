/**
 * SOFE 2715: Data Structures and Algorithms
 */

import java.math.BigInteger;
import java.util.Scanner;

public class RationalNumberTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Keep prompting the user until a valid integer is entered
        int N;
        while (true) {
            System.out.println("Enter the number of tests:");
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                // Consume the invalid input to avoid an infinite loop
                scanner.nextLine();
            }
        }

        // Consume the newline character
        scanner.nextLine();

        long totalExecutionTime = 0; // Initialize total execution time

        // Timing measurement encapsulated around the loop
        for (int i = 0; i < N; i++) {
            System.out.println("Enter test #" + (i + 1) + " input:");
            String input = scanner.nextLine();
            long loopStartTime = System.nanoTime(); // Start measuring loop execution time
            if (input.contains("/")) {
                // Take in the rational number with a division operator, then convert to tree path
                String[] numbers = input.split("/");
                BigInteger p = new BigInteger(numbers[0]);
                BigInteger q = new BigInteger(numbers[1]);
                System.out.println(rationalToTreePath(p, q));
            } else {
                // Convert the path to a rational number and print the result
                System.out.println(treePathToRational(input));
            }
            long loopEndTime = System.nanoTime(); // Stop measuring loop execution time
            long loopExecutionTime = loopEndTime - loopStartTime; // Calculate loop execution time
            totalExecutionTime += loopExecutionTime; // Add current loop execution time to total
        }

        double seconds = (double) totalExecutionTime / 1_000_000_000.0; // Convert total execution time to seconds

        System.out.println("Total execution time: " + seconds + " seconds");

        scanner.close();
    }

    // Function to convert a rational number to a tree path
    public static String rationalToTreePath(BigInteger p, BigInteger q) {
        // StringBuilder to construct the treePath
        StringBuilder treePath = new StringBuilder();
        BigInteger leftNumer = BigInteger.ZERO;
        BigInteger leftDenom = BigInteger.ONE;
        BigInteger rightNumer = BigInteger.ONE;
        BigInteger rightDenom = BigInteger.ZERO;

        // Continue until the target rational number is reached
        while (!p.equals(leftNumer.add(rightNumer)) || !q.equals(leftDenom.add(rightDenom))) {
            BigInteger mediantNumer = leftNumer.add(rightNumer);
            BigInteger mediantDenom = leftDenom.add(rightDenom);

            // Compare the target with the mediant of left and right
            if (p.multiply(mediantDenom).compareTo(q.multiply(mediantNumer)) > 0) {
                treePath.append('R');
                leftNumer = mediantNumer;
                leftDenom = mediantDenom;
            } else {
                treePath.append('L');
                rightNumer = mediantNumer;
                rightDenom = mediantDenom;
            }
        }

        //Output the tree path as a string
        return treePath.toString();
    }

    // Function to convert a path in the tree to a rational number
    public static String treePathToRational(String treePath) {
        BigInteger leftNumer = BigInteger.ZERO;
        BigInteger leftDenom = BigInteger.ONE;
        BigInteger rightNumer = BigInteger.ONE;
        BigInteger rightDenom = BigInteger.ZERO;

        // Process each character in the path
        for (char c : treePath.toCharArray()) {
            if (c == 'L') {
                rightNumer = rightNumer.add(leftNumer);
                rightDenom = rightDenom.add(leftDenom);
            } else if (c == 'R') {
                leftNumer = leftNumer.add(rightNumer);
                leftDenom = leftDenom.add(rightDenom);
            } else {
                System.out.println("Invalid input. Please enter only 'L' or 'R'. Or a rational number in the form of p/q. Try again.");
                return "";
            }
        }

        // Return the rational number result in string format
        return leftNumer.add(rightNumer) + "/" + leftDenom.add(rightDenom);
    }
}
