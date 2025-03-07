package is.hi.avg4.hbv202g.ass4_2;

import java.util.Random;
import java.util.Scanner;

public class Game {
    
    private String paper;
    private String rock;
    private String scissors;

    public Game() {
        paper = "paper";
        rock = "rock";
        scissors = "scissors";
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int randomNum = rand.nextInt(3);
        String computer = "";
        
        if (randomNum == 0) {
            computer = paper;
        } else if (randomNum == 1) {
            computer = rock;
        } else if (randomNum == 2) {
            computer = scissors;
        }

        System.out.println("Computer has chosen: " + computer);
        System.out.print("Your turn (paper, rock, or scissors): ");
        String player = scanner.nextLine().toLowerCase(); 

        
        if (!(player.equals(paper) || player.equals(rock) || player.equals(scissors))) {
            System.out.println("Invalid choice. Please choose paper, rock, or scissors.");
            return; 
        }

        
        System.out.println("You chose: " + player);
        
        if (player.equals(computer)) {
            System.out.println("It's a tie!");
        } else if (player.equals(paper) && computer.equals(rock)) {
            System.out.println("You win! Paper beats rock.");
        } else if (player.equals(rock) && computer.equals(scissors)) {
            System.out.println("You win! Rock beats scissors.");
        } else if (player.equals(scissors) && computer.equals(paper)) {
            System.out.println("You win! Scissors beats paper.");
        } else {
            System.out.println("You lose!");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}

    