import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[10][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j + 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr" + i + ": " + Arrays.toString(arr[i]));
        }
    }
}