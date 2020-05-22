import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame {

private static int drawNumber() {
    return new Random().nextInt(101);
}


public static void main(String[] args) {

    Scanner reader = new Scanner(System.in);

    while(true) {
        System.out.println("Guess a number: ");        
        int num = Integer.parseInt(reader.nextLine());
        int numberDrawn = drawNumber();


        if (numberDrawn > num) {
            System.out.println("The number is greater");

        }   else if (numberDrawn < num) { 
            System.out.println("The number is lesser");

        }   else {
            break;
        }

    }

    System.out.println("Congratulations, your guess is correct!");
}