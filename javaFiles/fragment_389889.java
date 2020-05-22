public class PrimeCheck {
    public boolean primeCheck (int num) {
        for (int i = num - 1; i > 1; i--) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}