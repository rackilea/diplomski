public class CountOne {

    public static int countOne(int n) {
        int count = 0;
        int mod;
        while (n > 0) {
            mod = n % 10;
            n /= 10;
            if (mod == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int sum = 1;
        for (int i = 2;; i++) {
            sum += countOne(i);
            if (sum == i) {
                System.out.println(i);
                break;
            }
        }
    }
}