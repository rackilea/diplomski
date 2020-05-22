public class Main {
    public static void main(String[] args) {
        long num = 600851475143L;
        long divisor = 2, largestPrimeFactor;
        while (num != 0) {
            if (num % divisor != 0) {
                divisor++;
            } else {
                largestPrimeFactor = num;
                num /= divisor;
                if (num == 1) {
                    System.out.println("The largest prime factor: " + largestPrimeFactor);
                    break;
                }
            }
        }
    }
}