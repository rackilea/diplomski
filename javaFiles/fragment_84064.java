import java.util.Scanner;
import java.util.Random;
public class HelloWorld {
    public static void main(String[] args) {
        //Not sure if it's a better way but I did this way:
        final int TRIES = 5;
        int heads = 0;
        for(int i=0; i<=TRIES; i++) {
            Scanner input = new Scanner(System.in);
            System.out.print("Do you wanna continue? Y or N? ");
            char c = input.next().charAt(0);
            c = Character.toUpperCase(c);
            if(c =='Y') {
                int r = (int) (Math.random() * 2) + 1;   //A number between 1 & 2
                if(r == 1) {
                    System.out.println("heads");
                    heads++;
                } else {
                    System.out.println("Lost");
                }
            } else {
              System.out.print(heads);
            }
        }
    }
}