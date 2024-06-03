import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int totalAttempts = 0;
        int roundsWon = 0;

        System.out.println("Welcome to Guess the Number!");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int userGuess = 0;

            System.out.println("\nI've picked a number between " + minRange + " and " + maxRange + ". Can you guess it?");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                totalAttempts++;
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the correct number (" + generatedNumber + ") in " + attempts + " attempts.");
                    roundsWon++;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == attemptsLimit && generatedNumber != userGuess) {
                System.out.println("Sorry, you've run out of attempts! The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");
        }

        System.out.println("\nThanks for playing Guess the Number!");
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Rounds won: " + roundsWon);
        scanner.close();
    }
}
