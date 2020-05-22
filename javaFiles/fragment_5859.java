import java.util.Arrays;

class Ideone {
    public static void main (String[] args) {
        int[] nums = new int[] { 7, -2, 5, 12 };
        System.out.println(smallest(nums));
    }

    private static int smallest(int... nums) {
        return Arrays.stream(nums).min().getAsInt();
    }
}