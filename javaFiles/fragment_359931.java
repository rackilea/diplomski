import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LotteryWithCollections {

    public static void main(String[] args) {

        List<Integer> correctNumbers = createSortedListOfRandomInts(6);
        System.out.println("Lottery numbers: " + correctNumbers);

        int tries = 0;
        List<Integer> guessNumbers = null;
        do {
            guessNumbers = createSortedListOfRandomInts(6);
            System.out.println("Guessed numbers: " + guessNumbers);
            tries++;
        } while (!guessNumbers.equals(correctNumbers));

        System.out.println("Lottery numbers: " + correctNumbers);
        System.out.println("WINNER! Number of tries: " + tries);
    }

    public static List<Integer> createSortedListOfRandomInts(int sizeOfList) {
        List<Integer> listOfRandomNumbers = new ArrayList<Integer>();
        Random randomGen = new Random();
        for (int i = 0; i < sizeOfList; i++) {
            int randomNum = randomGen.nextInt(50) + 1; // Random number created
                                                        // here.
            while (listOfRandomNumbers.contains(randomNum)) {
                randomNum = randomGen.nextInt(50) + 1;
            }
            listOfRandomNumbers.add(randomNum);
        }
        Collections.sort(listOfRandomNumbers);
        return listOfRandomNumbers;
    }
}