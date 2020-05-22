import java.util.ArrayList;
import java.util.Scanner;

public class HighestGrade {

    public static void main(String[] args){
        Scanner scan =  new Scanner(System.in);
        int greatest = -1;
        int count = 0;
        while (count<5) {
            ++count;
            System.out.print("Enter a number: ");
            int input = scan.nextInt();
            if (input <= 100 && input >= 00) {
                if(input >= greatest)
                    greatest = input;

            }
            else{
                System.out.println("Error: Make sure the grade is between 0 and 100!\nEnter a new grade!");
            }
        }

        System.out.println("\nHighest grade: "+greatest);

    }
}