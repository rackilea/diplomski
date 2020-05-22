import java.util.Scanner;

    public class Snippet {
        public static long multiplyHighestTwoValues(Long[] numbers) {

            long maxOne = 0;
            long maxTwo = 0;
            for (long n : numbers) {
                if (maxOne < n) {
                    maxTwo = maxOne;
                    maxOne = n;
                } else if (maxTwo < n) {
                    maxTwo = n;
                }
            }

            long product = maxOne * maxTwo;
            return product;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            Long numbers[] = new Long[n];
            for (int i = 0; i < n; i++)
                numbers[i] = sc.nextLong();
            System.out.println(sumPairwise(numbers));
            sc.close();

        }
    }