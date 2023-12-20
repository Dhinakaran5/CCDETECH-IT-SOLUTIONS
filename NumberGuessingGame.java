import java.util.Random;
import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
        // Stores actual and guessed numbers
        int answer, guess;

        // Maximum value is 100
        final int MAX = 100;

        // Takes input using scanner
        Scanner in = new Scanner(System.in);

        // Random instance
        Random rand = new Random();

        boolean correct = false;

        // Correct answer
        answer = rand.nextInt(MAX) + 1;

        // Loop until the guess is correct
        while (!correct) {
            System.out.println("Guess a number between 1 and 100:");

            // Guess value
            guess = in.nextInt();

            // If guess is greater than actual
            if (guess > answer) {
                System.out.println("Too high, try again");
            }

            // If guess is less than actual
            else if (guess < answer) {
                System.out.println("Too low, try again");
            }

            // Guess is equal to the actual value
            else {
                System.out.println("Yes, you guessed the number.");
                correct = true;
            }
        }

        // Close the scanner and exit the program
        in.close();
        System.exit(0);
    }
}
