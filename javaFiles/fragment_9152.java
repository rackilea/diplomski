public class TwoBases {
    public static void main(String[] args) {
        long beg = System.nanoTime();
        solve(419, 792);
        System.out.println("Time needed to calculate: "+(System.nanoTime()-beg)/1000000.0 + "ms");
    }

    public static void solve(int a, int b) {
        int[] aDigits = new int[3];
        int[] bDigits = new int[3];
        for (int i = 0; i < 3; i++) {
            aDigits[2 - i] = (a / (int) Math.pow(10, i)) % 10;
            bDigits[2 - i] = (b / (int) Math.pow(10, i)) % 10;
        }
        for (int x = 10; x <= 15000; x++) {
            int numBaseX = digitsToBase10(aDigits, x);
            int y = 10;
            while (y <= 15000) {
                int numBaseY = digitsToBase10(bDigits, y);
                if (numBaseX == numBaseY) {
                    System.out.println("Base X: " + x + " Base Y: " + y);
                    return;
                } else if (numBaseY > numBaseX) {
                    break;
                } else {
                    y++;
                }
            }
        }
        System.out.println("Nothing found");
    }

    public static int digitsToBase10(int[] digits, int b) {
        int res = 0;
        for (int i = 0; i < digits.length; i++) {
            res += digits[i] * (int) Math.pow(b, digits.length - 1 - i);
        }
        return res;
    }
}