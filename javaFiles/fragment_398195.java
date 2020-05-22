public void traversingMatrix(int i, int j) {

    if (i >= maxRow || j >= maxCol) {
        return;
    }
    traversingMatrix(i, j + 1);
    if (j == 0) traversingMatrix(i + 1, j);
}