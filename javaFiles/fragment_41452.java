public class GetMaxIndex {
    public static void main(final String[] args) {
        final double[] numbers = { 1.9, 2.9, 3.4, 3.5 };
        double maxNumber = numbers[0];
        int maxIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
                maxIndex = i;
            }
        }
        System.out.println("Max is " + maxNumber);
        System.out.println("Index of max is " + maxIndex);
    }
}