package xyz;

public class DigitCounter {

    public static void main(String[] args) {
        DigitCounter me = new DigitCounter();
        System.out.println(me.frequentDigit(24, 27, 30, 31, 34, 37, 40, 42));
        System.out.println(me.frequentDigit(12345, 54321, 24, 159, 2468, 98765,
                0, 1020304050));
        System.out.println(me.frequentDigit(123, -654, 879));
        System.out.println(me.frequentDigit(0));
    }

    public int frequentDigit(int... numbers) {
        int c[] = separateDigits(numbers);
        int p = findMax(c);
        return p;
    }

    int[] separateDigits(int[] numbers) {
        int c[] = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            int aNumber = numbers[i];
            if (aNumber == 0)
                c[0]++;
            else {
                while (aNumber > 0) {
                    int aDigit = aNumber % 10;
                    c[aDigit]++;
                    aNumber = aNumber / 10;
                }
            }
        }
        return c;
    }

    int findMax(int c[]) {
        int max = c[0];
        int max_i = 0;
        for (int i = 1; i < c.length; i++) {
            if (c[i] > max) {
                max = c[i];
                max_i = i;
            }
        }
        return max_i;
    }
}