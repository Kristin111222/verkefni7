import java.util.Random;
import java.util.Scanner;

public class Game {

    // Enum for the game choices
    public enum Choice {
        STONE, SCISSORS, PAPER
    }

    // Enum for the game results
    public enum Result {
        WIN, LOSE, TIE
    }

    // The main method - entry point of the program
    public static void main(String[] args) {
        Game game = new Game();
        game.play();  // Start the game
    }

    // Method to play the game
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            // Get the human player's choice
            Choice playerChoice = getPlayerChoice(scanner);

            // Get the computer's random choice
            Choice computerChoice = getComputerChoice();

            // Display the choices
            System.out.println("You chose: " + playerChoice);
            System.out.println("Computer chose: " + computerChoice);

            // Evaluate the game result
            Result result = evaluateGame(playerChoice, computerChoice);

            // Display the result
            displayResult(result);

            // Ask if the player wants to continue
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine();
            continuePlaying = response.equalsIgnoreCase("yes");
        }

        scanner.close();
    }

    // Method to get the human player's choice
    private Choice getPlayerChoice(Scanner scanner) {
        Choice choice = null;
        while (choice == null) {
            System.out.print("Enter your choice (stone, scissors, paper): ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "stone":
                    choice = Choice.STONE;
                    break;
                case "scissors":
                    choice = Choice.SCISSORS;
                    break;
                case "paper":
                    choice = Choice.PAPER;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'stone', 'scissors', or 'paper'.");
            }
        }
        return choice;
    }

    // Method to get the computer's random choice
    private Choice getComputerChoice() {
        Random random = new Random();
        int choiceIndex = random.nextInt(3);  // Randomly choose between 0, 1, or 2
        return Choice.values()[choiceIndex];  // Correct assignment, using an enum value
    }

    // Method to evaluate the result of the game
    private Result evaluateGame(Choice playerChoice, Choice computerChoice) {
        if (playerChoice == computerChoice) {
            return Result.TIE;
        }

        switch (playerChoice) {
            case STONE:
                return (computerChoice == Choice.SCISSORS) ? Result.WIN : Result.LOSE;
            case SCISSORS:
                return (computerChoice == Choice.PAPER) ? Result.WIN : Result.LOSE;
            case PAPER:
                return (computerChoice == Choice.STONE) ? Result.WIN : Result.LOSE;
            default:
                return Result.TIE;  // This should never happen
        }
    }

    // Method to display the result
    private void displayResult(Result result) {
        switch (result) {
            case WIN:
                System.out.println("You win!");
                break;
            case LOSE:
                System.out.println("You lose!");
                break;
            case TIE:
                System.out.println("It's a tie!");
                break;
        }
    }
}

