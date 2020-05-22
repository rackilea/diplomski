public class Testy {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            sum = (sum << 8) + val;
        }
        System.out.println("final: " + sum);
    }
}