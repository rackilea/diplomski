public class Program {

    public static void main(String[] args) {
        int total = 0;
        int previousValue = 0;
        int currentValue = 1;
        while (currentValue < 4_000_000) {
            int nextPreviousValue = currentValue;
            currentValue += previousValue;
            previousValue = nextPreviousValue;
            total += fibo(currentValue);
        }
        System.out.println(total);
    }

    public static int fibo(int i) {
        if (i % 2 == 0) {
            return i;
        }
        return 0;
    }
}