import java.util.Arrays; // you need this to use Arrays.toString()

public class ItemSet {
    public static void main(String []args) {
        int[] itemSet;
        itemSet = new int[5];

        int count = 1;
        int assignItem = 0;
        int countTwo = 1;

        for (int i = 0; i < itemSet.length; i++) {
            itemSet[i] = (int) (Math.random() * 76);
            for (int j = i - 1; j >= 0; j--) {
                if (itemSet[j] == itemSet[i]) {
                    System.out.println("Comparing " + itemSet[j] +
                        " and " + itemSet[i]);
                    i--;
                    break; // not really needed but illustrates a way to exit a loop immediately
                }
            }
        }

        // this is a handy way to print all the data in an array quickly
        System.out.println(Arrays.toString(itemSet));
    }
}