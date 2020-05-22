import java.io.*;
import java.util.Arrays;

public class dont {

    public static void main(String[] args) throws Exception  {
        int[] counts = input();

        System.out.println("The number of times it rolls 4 on two 6  sided dice :" + counts[4]);
        System.out.println("The number of times each number was the sum:" + Arrays.toString(counts);
    }

    public static int[] input () throws IOException {
        BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Hello and welcome to the program");
        System.out.println("In this program two six sided dices will be rolled and one eleven sided dice will be rolled (1000 times each"); // We don't actually roll any eleven-sided dice, so I'm not sure why this is here?
        int[] counts = new int[13];

        System.out.println("The dices will be rolled to determine the odds of how many times the roll 2 comes up on both dies(Press any key to con't) ");
        myInput.readLine();
        for (int i = 0; i < 1000; i++) 
        {
            int sumOfDice = (int)(Math.random ()*6+1) + (int)(Math.random ()*6+1);
            counts[sumOfDice]++;
        }

        // return array to main
        return counts;
    }
}