import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class HelloArcher {

    private static int[] randomInteger;

    public static void main(String[] args) {
        int[] num = getRandArray(100);
        Scanner s = new Scanner(System.in); 
        while(true) {
            int indx = getUserIndex(s);
            System.out.println("Index:" + indx);

            if(indx < 0 || indx > num.length) {
                // throw new ArrayIndexOutOfBoundsException("Wrong index bro");
                continue;
            }    
            System.out.println("Value at index: " + num[indx] );
        }
    }

    public static int[] getRandArray(int n) {
        int[] randomInteger = new int[n];
        Random rand = new Random();
        for (int i = 0; i < randomInteger.length; i++)
            randomInteger[i] = rand.nextInt();

        return randomInteger;
    }

    public static int getUserIndex(Scanner s) {
        System.out.println("Please enter a valid integer between 0 and 100 or type quit to exit: ");
        String in = s.next();
        if(in.equals("quit")) 
            System.exit(0);

        int indx = -1;

        try { 
            indx = Integer.parseInt(in);
        } catch (InputMismatchException | NumberFormatException | IndexOutOfBoundsException ex) {
            // weird value entered - run function again; quit is the only way to exit
            indx = getUserIndex(s);
        }
        return indx;
    }
}