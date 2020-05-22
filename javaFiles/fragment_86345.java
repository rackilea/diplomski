public class StackOverflow {
    public static void main(String args[]) {
        int m = 7;
        int n = 5;
        int sum = 10;

        // Take the larger of the two inputs
        int limit = m > n ? m : n;

        int count = 0;
        for (int i = 1; i <= limit; i++) {
            int possibleN = sum - i;

            // Check that the possibleN is greater than 0 and less than n
            if (0 < possibleN && possibleN <= n) {
                System.out.printf("%d + %d = %d\r\n", i, possibleN, sum);
                count++;
            }
        }

        System.out.printf("There are %d ways to get %d\r\n", count, sum);
    }
}