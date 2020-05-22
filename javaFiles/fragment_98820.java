public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[5][6];

        int counter = 1;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 6; j++) {
                matrix[i][j] = counter++;
            }
        }

        int newArray[] = new int[matrix.length*matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for(int j = 0; j < row.length; j++) {
                int number = matrix[i][j];
                newArray[i*row.length+j] = number;
            }
        }
        for(int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}