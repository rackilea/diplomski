import java.util.Arrays;
import java.util.Random;

public class LotteryMain {
    public static void main(String[] args) {

        int[] correctNumbers = createSortedArrayOfRandomInts(6);
        System.out.println("Lottery numbers: "+Arrays.toString(correctNumbers));

        int tries = 0;
        int[] guessNumbers = null;
        do{
            guessNumbers = createSortedArrayOfRandomInts(6);
            System.out.println("Guessed numbers: "+Arrays.toString(guessNumbers));
            tries++;
        }while(!Arrays.equals(guessNumbers, correctNumbers));

        System.out.println("Lottery numbers: "+Arrays.toString(correctNumbers));
        System.out.println("WINNER! Number of tries: "+tries);
    }

    public static int[] createSortedArrayOfRandomInts(int sizeOfArray){
        int[] arrayOfRandomNumbers = new int[sizeOfArray];
        Random randomGen = new Random();
        for (int i = 0; i < sizeOfArray; i++) {
            int randomNum = -1;
            do{
                randomNum = randomGen.nextInt(50)+1; // Random number created here.
            }while(contains(arrayOfRandomNumbers, randomNum));
            arrayOfRandomNumbers[i] = randomNum;
        }
        Arrays.sort(arrayOfRandomNumbers);
        return arrayOfRandomNumbers;
    }

    public static boolean contains(int[] array, int searchFor){
        for(int i = 0; i < array.length; i++){
            if(array[i] == searchFor)
                return true;
        }
        return false;
    }

}