public class ItemSet {
    public static void main(String []args) {
        int[] itemSet;
        itemSet = new int[5];

        int count = 1;
        int assignItem = 0;
        int countTwo = 1;

        for (int i = 0; i < itemSet.length; i++) {
            itemSet[i] = (int) (Math.random() * 76);
        }
    }
}