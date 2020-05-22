import java.util.Scanner;
import java.util.Random;

public class Appels {
    public static Scanner Andrew = new Scanner(System.in);
    public static Random Hello = new Random();
    public static double compAnswer;
    public static String compChoice;
    public static String answer;
    public static void main(String [] args){
        getAnswer();
        showCompAnswer();
        decideWinner();
    }
    public static void getAnswer(){
        System.out.println("Welcome to Rock, Paper, Scissors Vs. the computer.\nWhich do you choose:");
        answer = Andrew.nextLine();
    }
    public static void showCompAnswer() {
        compAnswer = Hello.nextDouble();
        if(compAnswer > .66){
            compChoice = "rock";
        } else if(compAnswer > .33) {
            compChoice = "paper";
        } else{
            compChoice = "scissors";
        }
        System.out.println(compChoice);
    }
    public static void decideWinner(){
        if(compChoice.equals(answer)){
            tie();
        } else if ((compChoice.equalsIgnoreCase("rock") && answer.equals("scissors")) ||
                (compChoice.equalsIgnoreCase("paper") && answer.equals("rock")) ||
                (compChoice.equalsIgnoreCase("scissors") && answer.equals("paper"))) {
            compWin();
        } else {
            userWin();
        }

    }
    public static void tie(){
        System.out.println("It's a tie.");
    }
    public static void compWin(){
        System.out.println("The computer wins. :(");
    }
    public static void userWin(){
        System.out.println("You win!");
    }
}