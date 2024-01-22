import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean RUNNING = true;

        System.out.println("############################");
        System.out.println("Rock, Paper, Scissors: ");
        Scanner userInput = new Scanner(System.in);


        while(RUNNING)
        {
            String playerIntention = "";
            while(!(playerIntention.equals("1") || playerIntention.equals("2") || playerIntention.equals("3"))) {

                System.out.println("1 - Rock \n2 - Paper\n3 - Scissors");
                System.out.println("What is your move?");
                playerIntention = userInput.nextLine();
            }
            double pcIntention = Math.random()*3;


            // Check winner
            String printWinner = checkWinner(playerIntention, pcIntention);

            System.out.println(printWinner);

            // RESTART
            RUNNING = restartGame(userInput);
            System.out.println("############################");
        }
    }

    private static String checkWinner(String playerIntention, double pcIntention){
        int playerMove = Integer.parseInt(playerIntention);
        int pcMove = (int) pcIntention;

        ArrayList<String> options = new ArrayList<>(Arrays.asList("Rock", "Paper", "Scissors"));

        System.out.println("----------------------------");
        System.out.println("You played: " + options.get(playerMove-1));
        System.out.println("----------------------------");
        System.out.println("Computer played: " + options.get(pcMove));
        System.out.println("----------------------------");

        if (playerMove == pcMove){
            return "It's a tie!";
        }else if((playerMove==1&&pcMove==2) || (playerMove==2&&pcMove==3) ||(playerMove==3&&pcMove==1)){
            return "The computer wins!";
        }
        else{
            return "Congratulations! You win!";
        }
    }

    private static boolean restartGame(Scanner playerChoice){
        System.out.println("Play again? y/n");
        String playAgain = playerChoice.nextLine();
        return playAgain.equalsIgnoreCase("y");
    }
}