import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.printf("You rolled: die1 = %d, die2 = %d with a sum of %d\n", die1, die2, sum);
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lost!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won!");
            } else {
                int point = sum;
                System.out.printf("Point = %d\n", point);
                boolean pointGained = false;
                while (!pointGained) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.printf("You rolled: die1 = %d, die2 = %d with a sum of %d\n", die1, die2, sum);
                    if (sum == 7) {
                        System.out.println("You rolled a 7 and lost!");
                        pointGained = true;
                    } else if (sum == point) {
                        System.out.printf("You rolled the point of %d! You win!\n", point);
                        pointGained = true;
                    }
                }
            }
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to play again? (y/n): ");
                String userInput = input.nextLine();
                if (userInput.equalsIgnoreCase("y")) {
                    playAgain = true;
                    validInput = true;
                } else if (userInput.equalsIgnoreCase("n")) {
                    playAgain = false;
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            }
        }
        System.out.println("Thank you for playing!");
        input.close();
    }
}
