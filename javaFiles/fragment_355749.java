public static String[] getUnique(String[][] matrix) {
    List<String> unique = new ArrayList<>();

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
                unique.add(matrix[row][col]);
            else
                matrix[row][col] = null;
        }
    }

    return unique.toArray(new String[unique.size()]);
}