import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        //Create scanner and random tools
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        //Game settings
        int gameNo = 1;
        int totalScore = 0;
        
        System.out.println("=================================");
        System.out.println("WELCOME TO  THE NUMBER GUESSING GAME");
        System.out.println("=================================");

        System.out.print("Do you want to start the game? (yes/no): ");
        String start = sc.next();

        if (!start.equalsIgnoreCase("yes")) {
            System.out.println("Thank You!");
            sc.close();
            return;
        }
        //Rules for this game
        System.out.println("\n******** RULES ********");
        System.out.println("1. Guess a number between 1 and 100");
        System.out.println("2. You have only 10 chances");
        System.out.println("3. Too High / Too Low hints will be given");
        System.out.println("4. Score depends on remaining chances");
        System.out.println("************************\n");

        boolean continueGame = true;

        while (continueGame) {
            //Generate secret number between 1 and 100
            int secretNumber = random.nextInt(100) + 1;
            boolean won = false;
            int score = 0;

            System.out.println("\n===== GAME " + gameNo + " =====");

            for (int attempt = 1; attempt <= 10; attempt++) {

                System.out.print("Chance " + attempt + "/10 - Enter your guess: ");
                int guess = sc.nextInt();
                // Evaluate user guess
                if (guess == secretNumber) {

                    score = (11 - attempt) * 10;

                    System.out.println("Congratulations!");
                    System.out.println("You guessed the correct answer!");
                    System.out.println("Score: " + score);

                    totalScore += score;
                    won = true;
                    break;

                } else if (guess > secretNumber) {

                    System.out.println("Too High! Try a lower number.\n");

                } else {

                    System.out.println("Too Low! Try a higher number.\n");
                }
            }

            if (!won) {
                System.out.println("Game Over!You ran out of attempts.");
                System.out.println("The correct Number was: " + secretNumber);
                System.out.println("Score: 0");
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to continue? (yes/no): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                gameNo++;
            } else {
                continueGame = false;
            }
        }
        //Final game evaluation
        System.out.println("\n=================================");
        System.out.println("THANK YOU FOR PLAYING");
        System.out.println("FINAL SCORE: " + totalScore);
        System.out.println("=================================");
        //Close resources
        sc.close();
    }
}