import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
//    global variable for all the options
    private final static String[] choices = {"Rock","Paper","Scissors"};

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            runGame();

            String playAgainInput = getInputStr("Do you want to play again? (No/Yes)").toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        System.exit(0);
    }

    public static void runGame() {
        // round input and validation
        int numberOfRounds = getInputInt("How many rounds would you like to play? (1-10)");

        if (numberOfRounds < 0 || numberOfRounds > 10) {
            System.exit(1);
        }

        // Game variables
        int CPUWins = 0;
        int playerWins = 0;
        int ties = 0;
        Random random = new Random();

        // Game loop
        for(int round = 0; round < numberOfRounds; round++) {
            System.out.printf("Round %d of %d%n",round+1, numberOfRounds);

            int playerChoice = getUserChoice();
            int CPUChoice = random.nextInt(3)+1; // range of 1 -> 3 (both inclusive)

            System.out.printf("CPU Chose %s%n", choices[CPUChoice-1]);
            // tied
            if (playerChoice == CPUChoice) {
                System.out.println("Tied!");
                ties++;
            }
            // player wins
            else if (isPlayerWinner(playerChoice,CPUChoice)) {
                System.out.println("Player Wins!\n");
                playerWins++;
            }
            // player loses
            else {
                System.out.println("CPU Wins!\n");
                CPUWins++;
            }
        }

        // Show summary of rounds
        String winner = playerWins == CPUWins ? "Tied" : playerWins > CPUWins ? "Player Wins" : "CPU Wins";
        System.out.printf("Ties: %d\nPlayer Wins: %d\nCPU Wins: %d \nWinner is %s!%n",ties, playerWins, CPUWins,winner);
    }

//    Checks to see if player won
    public static boolean isPlayerWinner(int playerChoice, int cpuChoice) {
        return (playerChoice == 1 && cpuChoice == 3) ||     // rock beats scissors
                (playerChoice == 2 && cpuChoice == 1) ||    // paper beats rock
                (playerChoice == 3 && cpuChoice == 2);      // scissors beats paper
    }

    public static int getUserChoice() {
        int userChoice = -1;

        do {
            System.out.println("Please pick one of the following:");
            for (int i = 0; i < choices.length; i++) {
                System.out.println("(" + (i + 1) + ") " + choices[i]);
            }
            userChoice = getInputInt("Your choice: ");
            if (userChoice < 1 || userChoice > choices.length) {
                System.out.println("Invalid choice. Please enter a number between 1 and " + choices.length + ".");
            }

        } while (userChoice < 0 || userChoice >= choices.length);

        return userChoice;
    }

    public static int getInputInt(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static String getInputStr(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}