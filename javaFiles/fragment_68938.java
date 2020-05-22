import java.util.Scanner;
import static java.lang.System.out;

public class TestingStuf2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

            out.println("Enter a number");

            int number = keyboard.nextInt();

        do{
            if (number < 10) {
               out.println("This number is too small.");
               /*
                * You should reassign number here
                */
               number = keyboard.nextInt();
           }else{
               out.println("This number is big enough.");
           }    
        }while(number < 10);
        keyboard.close();
    }

}