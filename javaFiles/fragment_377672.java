public class Main {

    public static void main(String[] args) {
        int[][] array = {{2, 4, 6, 8, 10, 12, 14, 16}, {4, 6, 8, 10, 12, 14, 16, 18}, {6, 8, 10, 12, 14, 16, 18, 20}};
        for (int i = 0; i < array.length; i++) {
            System.out.print("output of row " + i + ": ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }
}