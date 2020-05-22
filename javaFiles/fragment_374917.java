static int[][] removeRow(int[][] data, int r) {
    int[][] ret = new int[data.length - 1][];
    System.arraycopy(data, 0, ret, 0, r);
    System.arraycopy(data, r+1, ret, r, data.length - r - 1);
    return ret;
}

static int[][] removeColumn(int[][] data, int c) {
    for (int r = 0; r < data.length; r++) {
        int[] row = new int[data[r].length - 1];
        System.arraycopy(data[r], 0, row, 0, c);
        System.arraycopy(data[r], c+1, row, c, data[r].length - c - 1);
        data[r] = row;
    }
    return data;
}