int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {
    Set<Integer> rowsDel = new HashSet<>();
    Set<Integer> colsDel = new HashSet<>();

    for (int e : rowsToDelete) { rowsDel.add(e); }
    for (int e : columnsToDelete) { colsDel.add(e); }

    int[][] newMatrix = new int[matrix.length-rowsDel.size()]
                               [matrix[0].length-colsDel.size()];

    for (int i = 0, newI = 0; i < matrix.length; i++) {
        if (!rowsDel.contains(i)) {
            for (int j = 0, newJ = 0; j < matrix[i].length; j++) {
                if (!colsDel.contains(j)) {
                    newMatrix[newI][newJ++] = matrix[i][j];
                }
            }

            newI++;
        }
    }

    return newMatrix;
}