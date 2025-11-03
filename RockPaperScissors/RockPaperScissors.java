import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private final static String[] choices = {"Rock","Paper","Scissors"};
    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            runGame();

            String playAgainInput = askInputStr("Do you want to play again? (No/Yes)").toLowerCase();
            playAgain = playAgainInput.equals("yes") ? true : false;
        }
        System.exit(0);

    }

    public static void runGame() {
        // round input and validation
        int numberOfRounds = askInputInt("How many rounds would you like to play? (1-10)");

        if (numberOfRounds < 0 || numberOfRounds > 10) {
            System.exit(1);
        }

        // Game variables
        int cpu_wins = 0;
        int player_wins = 0;
        int ties = 0;
        Random random = new Random();

        // Game loop
        for(int round = 0; round < numberOfRounds; round++) {
            System.out.println(String.format("Round %d of %d",round+1, numberOfRounds));
            int player_choice = askInputInt("Please pick one of the following\n(1) Rock \n(2) Paper \n(3) Scissors");
            int cpu_choice = random.nextInt(3)+1; // range of 1 -> 3 (both inclusive)

            System.out.println(String.format("CPU Chose %s", choices[cpu_choice-1]));
            // tied
            if (player_choice == cpu_choice) {
                System.out.println("Tied!");
                ties++;
            }
            // player wins
            else if (
                (player_choice == 1 && cpu_choice == 3) ||
                (player_choice == 2 && cpu_choice == 1) ||
                (player_choice == 3 && cpu_choice == 2)
            ) {
                System.out.println("Player Wins!\n");
                player_wins++;
            }
            // player loses
            else {
                System.out.println("CPU Wins!\n");
                cpu_wins++;
            }
        }

        // Show summary of rounds
        String winner = player_wins == cpu_wins ? "Tied" : player_wins > cpu_wins ? "Player Wins" : "CPU Wins"; 
        System.out.println(String.format("Ties: %d\nPlayer Wins: %d\nCPU Wins: %d \nWinner is %s!",ties,player_wins,cpu_wins,winner));

    }

    public static int askInputInt(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static String askInputStr(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}