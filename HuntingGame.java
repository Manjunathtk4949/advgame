import java.util.Scanner;

public class HuntingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerName;
        int playerScore = 0;

        System.out.println("Welcome to the Hunting Adventure Game!");
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();

        System.out.println("\nHello, " + playerName + "! You are on a hunting trip in the wilderness.");
        System.out.println("Your goal is to score as many points as possible.");

        while (true) {
            System.out.println("\nYou are at a crossroads. What will you do?");
            System.out.println("1. Go hunting for deer");
            System.out.println("2. Explore a nearby cave");
            System.out.println("3. Quit the game");

            int choice = getUserChoice(scanner, 1, 3);

            if (choice == 1) {
                int huntingResult = huntDeer();
                playerScore += huntingResult;
                System.out.println("You've scored " + huntingResult + " points!");
            } else if (choice == 2) {
                int caveResult = exploreCave();
                playerScore += caveResult;
                System.out.println("You've scored " + caveResult + " points!");
            } else {
                System.out.println("Thanks for playing, " + playerName + "!");
                System.out.println("Your total score is: " + playerScore);
                break;
            }
        }
    }

    public static int getUserChoice(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    scanner.nextLine(); // Consume the newline character
                    return choice;
                }
            }
            System.out.println("Invalid choice. Please enter a valid option.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    public static int huntDeer() {
        int outcome = (int) (Math.random() * 3); // 0, 1, or 2 points
        System.out.println("You went deer hunting and...");
        if (outcome == 0) {
            System.out.println("Unfortunately, you missed the shot!");
        } else if (outcome == 1) {
            System.out.println("You hit a deer and got 1 point.");
        } else {
            System.out.println("You made a perfect shot and got 2 points!");
        }
        return outcome;
    }

    public static int exploreCave() {
        int outcome = (int) (Math.random() * 3); // 0, 1, or 2 points
        System.out.println("You entered a dark cave and...");
        if (outcome == 0) {
            System.out.println("You found nothing of value.");
        } else if (outcome == 1) {
            System.out.println("You discovered a hidden treasure and got 1 point.");
        } else {
            System.out.println("You encountered a dangerous animal and barely escaped with 2 points!");
        }
        return outcome;
    }
}
