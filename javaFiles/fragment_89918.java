public class NthStrangePrime {
    public static void main(String args[]) {
        System.out.println("29 is : " + isStrangePrime(29));
        System.out.println("13 is : " + isStrangePrime(13));
        System.out.println("14 is : " + isStrangePrime(14));
        System.out.println("15 is : " + isStrangePrime(15));
        System.out.println("16 is : " + isStrangePrime(16));
        System.out.println("17 is : " + isStrangePrime(17));

        System.out.println("13th strange number is : " + nThStrangePrime(13));
    }

    public static int nThStrangePrime(int n){
        int strangePrimes = 0;
        int number = 2;
        while (strangePrimes != n){
            if (isStrangePrime(number)){
                strangePrimes++;
                System.out.println("This is a Strange Prime :"+number);
            }
            number++;
        }
        return number-1;
    }

    public static boolean isStrangePrime(int n) {
        while ((n > 9) && (isItPrime(n))){
            n = sumDigit(n);
        }            
        if ((n <= 9) && (isItPrime(n))){
            return true;
        } else {
            return false;
        }
    }

    public static int sumDigit(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static boolean isItPrime(int n) {
        if (n <= 1){
            return false;
        }
        if (n == 2) {
            return true;
        }

        boolean isPrimeNumber = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrimeNumber = false;
                break; // exit the inner for loop
            }
        }

        return isPrimeNumber;
    }
}