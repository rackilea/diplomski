public class MatrixColumns {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3}, 
            {2, 0, 0}, 
            {0, 0, 2}
        };

        int[][] secondMatrix = {
            {1, 2, 3}, 
            {2, 2, 2}, 
            {0, 0, 0}
        };

        int[][] thirdMatrix = {
            {2, 2, 2}, 
            {2, 2, 2}, 
            {2, 2, 2}
        };

        int num = 2;
        System.out.println("The result is: " + checkColumns(matrix, num, false));
        System.out.println("The result is: " + checkColumns(secondMatrix, num, false));
        System.out.println("The result is: " + checkColumns(thirdMatrix, num, false));

        System.out.println("The result is: " + checkColumns(matrix, num, true));
        System.out.println("The result is: " + checkColumns(secondMatrix, num, true));
        System.out.println("The result is: " + checkColumns(thirdMatrix, num, true));
    }

    //This method returns the column in which the number was found and -1 if it wasn't found in any column
    private static int checkRow(int[] row, int num, int startFrom) {
        for (int i = startFrom == -1 ? 0 : startFrom; i < row.length; i++) {
            if (row[i] == num) {
                return i;
            }
        }
        return -1;
    }

    //If there can be more than 1 number 2 in each column, we set "allowRepeatInRow" to true and it will look for all the column values, otherwise set it to false
    public static boolean checkColumns(int matrix[][], int num, boolean allowRepeatInRow) {
        boolean[] results = new boolean[matrix.length]; //Array where we will store the results of each column

        int column = 0;
        int nextColumn = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (allowRepeatInRow) {
                do {
                    column = checkRow(matrix[i], num, nextColumn);
                    if (column != -1) {
                        results[column] = true; //We change the value to "true" on the column where the number was found for each row.
                    }
                    nextColumn = column + 1;
                } while (column < matrix.length - 1 && column != -1);
            } else {
                column = checkRow(matrix[i], num, 0);
                if (column != -1) {
                    results[column] = true; //We change the value to "true" on the column where the number was found for each row.
                }
            }
        }

        //We iterate over the results array, if any of them is "false" we return false as there is at least one column where the number was not found   
        for (int i = 0; i < results.length; i++) {
            if (!results[i]) {
                return false;
            }
        }

        return true; //We return true if the above method didn't found any false column, and thus all columns have at least one number "2"
    }
}