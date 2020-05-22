import java.util.Scanner;   

public class RockPaperScissors{   
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int compGoInt;
        String compGo;
        String playerGo;

        while(true) {
            System.out.println("You can type 'Exit' to quit the game at any time.");
            System.out.print("Please enter your choice. Rock, Paper or Scissors: ");
            playerGo = input.nextLine();

            if(playerGo.equalsIgnoreCase("Exit")) break;    //Checks for exit condition.
            else { //GameLogic

                compGoInt = (int) (Math.random() * 3);

                switch (compGoInt){
                case 0:
                    compGo = "Rock";
                    break;
                case 1:
                    compGo = "Paper";
                    break;
                case 2:
                    compGo = "Scissors";
                    break;
                default:
                    compGo = "Error";
                    System.out.println("Error.");
                    break;
                }

                if (playerGo.equals(compGo)){
                    System.out.println("Computer chooses "+compGo);
                    System.out.println("It's a draw!");
                }

                else if ((playerGo.equalsIgnoreCase("Rock") && compGo.equalsIgnoreCase("Scissors")) ||
                        (playerGo.equalsIgnoreCase("Paper") && compGo.equalsIgnoreCase("Rock")) ||
                        (playerGo.equalsIgnoreCase("Scissors") && compGo.equalsIgnoreCase("Paper"))){
                    System.out.println("Computer chooses "+compGo);
                    System.out.println("Player Wins!");
                }

                else if ((compGo.equalsIgnoreCase("Rock") && playerGo.equalsIgnoreCase("Scissors")) ||
                        (compGo.equalsIgnoreCase("Paper") && playerGo.equalsIgnoreCase("Rock")) ||
                        (compGo.equalsIgnoreCase("Scissors") && playerGo.equalsIgnoreCase("Paper"))){
                    System.out.println("Computer chooses "+compGo);
                    System.out.println("Computer Wins!");
                }

                else{
                    System.out.println("Something has gone wrong!");
                    System.out.println("Player chose "+playerGo);
                    System.out.println("Computer chose "+compGo);
                }
            }
        }
    }
}