public class Main {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 2, 3, 4 } };

        for (int i = 0; i < arr.length; i++) {
            int[] newArr = new int[arr[i].length - 1];
            for (int j = 1; j < arr[i].length; j++) {
                newArr[j - 1] = arr[i][j];
            }
            arr[i] = newArr;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}