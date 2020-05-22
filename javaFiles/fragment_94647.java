import java.util.Random;
import java.util.Scanner;

public class Dice {
    Random generator = new Random();
    Scanner keyboard = new Scanner(System.in);

    public void DiceCount() {
        int sides = 6;
        System.out.println("How many die? ");
        int count = keyboard.nextInt();
        int[] array = new int[count];
        int longestLength = 1, currentLength = 1, longestLengthIndex = 0, currentLengthIndex = 1;
        int currentNum = -1;
        for (int i = 0; i < count; i++) {
            array[i] = generator.nextInt(sides);
            System.out.print(array[i] + " ");
            if (currentNum == array[i]) {
                currentLength++;
                if (currentLength > longestLength) {
                    longestLengthIndex = currentLengthIndex;
                    longestLength = currentLength;
                }
            } else {
                currentLength = 1;
                currentLengthIndex = i;
            }
            currentNum = array[i];
        }
        System.out.println();
        for (int i = 0; i < count; i++)
            System.out.print((i == longestLengthIndex ? "(" : "") + array[i] + (i == (longestLengthIndex + longestLength - 1) ? ") " : " "));
    }
}