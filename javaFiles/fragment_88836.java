public class TrailingZero {
    public static int trailingZeroes(int n) {
        int result = 0;
        int base = 5;
        while (n/base > 0) {
            System.out.println("n = " + n/base  + " base = " + base);
            result += n/base;
            base *= 5;
        }

        return result;
    }

    public static int trailingZeroesV2(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroesV2(n / 5);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(trailingZeroes(1808548329));
        System.out.println(trailingZeroesV2(1808548329));
    }
}