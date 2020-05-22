import java.util.Scanner;

public class Test {

    public static final int ARRAY_LENGTH = 5;

    public static void main(String[] args) {
        int myArray[] = new int[ARRAY_LENGTH];



        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 5 numbers: ");

        for(int i = 0; i < myArray.length; i++)
            myArray[i] = input.nextInt();

        System.out.println("\nThe numbers are: ");
        printIntArray(myArray);

        shuffleArray(myArray);
        System.out.println("\nThe numbers, shuffled, are: ");
        printIntArray(myArray);

        input.close();  // no memory leaks!
    }

    // method for printing array
    public static void printIntArray(int[] array) {
        for(int i = 0; i < array.length; i++)
            System.out.printf("%2d ", array[i]);
        System.out.printf("%n");    // use %n for os-agnostic new-line
    }

    // method for shuffling array
    public static void shuffleArray(int[] array) {
        int range = array.length;
        boolean isShuffled[] = new boolean[range];  // store which positions are shuffled

        while(!isArrayShuffled(isShuffled)) {
            int positionSrc = getRandom(range);
            int positionDst = getRandom(range);

            swapArrayElement(array, positionSrc, positionDst);
            isShuffled[positionSrc] = true;
            isShuffled[positionDst] = true;
        }

    }

    public static int getRandom(int maxRange) {
        return (int)(Math.random()*maxRange);
    }

    public static void swapArrayElement(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean isArrayShuffled(boolean[] isShuffled) {
        for(int i = 0; i < isShuffled.length; i++)
            if(isShuffled[i] == false)
                return false;

        return true;
    }
}