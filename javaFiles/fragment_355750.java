public static String[] getUnique(String[][] matrix) {
    int total = 0;

    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] == null)
                continue;

            boolean foundUnique = true;

            for (int i = row; i < matrix.length; i++) {
                for (int j = i == row ? col : 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == null || (i == row && j == col))
                        continue;

                    if (matrix[i][j].equals(matrix[row][col])) {
                        foundUnique = false;
                        matrix[i][j] = null;
                    }
                }
            }

            if (foundUnique)
                total++;
            else
                matrix[row][col] = null;
        }
    }

    if (total == 0)
        return new String[0];

    String[] res = new String[total];

    for (int row = 0, i = 0; row < matrix.length; row++)
        for (int col = 0; col < matrix[row].length; col++)
            if (matrix[row][col] != null)
                res[i++] = matrix[row][col];

    return res;
}