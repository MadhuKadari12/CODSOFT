import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
       
      
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int noOfrounds = 0;
        int score = 0;

        boolean wantToPlayAgain = true;
        while (wantToPlayAgain) {
            int targetNumber =  random.nextInt(upperLimit-lowerLimit);
            System.out.println("----------------------------------------------------------------");
            System.out.println("Welcome to the Guessing the Number game!");
            System.out.println("I've selected a number between " + lowerLimit + " and " + upperLimit + ".");
         
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
               System.err.print("No of Attempts:"+ attempts++ +"\n");

                if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + targetNumber + ".");
            }

            noOfrounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            wantToPlayAgain = playAgain.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score is " + score + " points in " + noOfrounds + " rounds.");
    }
}