package cipherByte;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

	    private static final int MAX_ATTEMPTS = 5;
	    private static final int NUMBER_OF_ROUNDS = 3;
	    private static final int POINTS_PER_ATTEMPT = 10;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int totalScore = 0;

	        System.out.println("Welcome to the Guess the Number Game!");

	        for (int round = 1; round <= NUMBER_OF_ROUNDS; round++) {
	            int randomNumber = random.nextInt(100) + 1;
	            int attempts = 0;
	            boolean roundWon = false;

	            System.out.println("\nRound " + round + " of " + NUMBER_OF_ROUNDS);
	            System.out.println("I have selected a random number between 1 and 100.");

	            while (attempts < MAX_ATTEMPTS) {
	                System.out.print("Enter your guess: ");
	                int userGuess = scanner.nextInt();
	                attempts++;

	                if (userGuess == randomNumber) {
	                    System.out.println("Congratulations! You've guessed the number correctly.");
	                    int roundScore = (MAX_ATTEMPTS - attempts + 1) * POINTS_PER_ATTEMPT;
	                    totalScore += roundScore;
	                    System.out.println("You've earned " + roundScore + " points this round.");
	                    roundWon = true;
	                    break;
	                } else if (userGuess < randomNumber) {
	                    System.out.println("The number is higher than your guess.");
	                } else {
	                    System.out.println("The number is lower than your guess.");
	                }
	            }

	            if (!roundWon) {
	                System.out.println("Sorry, you've used all attempts. The correct number was " + randomNumber + ".");
	            }
	        }

	        System.out.println("\nGame over! Your total score is: " + totalScore);
	        scanner.close();
	    }
}
