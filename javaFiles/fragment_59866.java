private static final int SIZE = 4;
private static final int BOX = 2;
private int[] sudoko = new int[SIZE * SIZE];

private boolean hasDuplicate(int pos) {
    int value = sudoko[pos];
    return IntStream.range(0, SIZE * SIZE)
        .filter(p -> p != pos)
        .filter(p -> sameRow(p, pos) || sameCol(p, pos) || sameBox(p, pos))
        .anyMatch(p -> sudoko[p] == value);
}

private boolean sameRow(int pos1, int pos2) {
    return pos1 / DIM == pos2 / DIM;
}

private boolean sameCol(int pos1, int pos2) {
    return pos1 % DIM == pos2 % DIM;
}

private boolean sameBox(int pos1, int pos2) {
    return pos1 / SIZE / BOX == pos2 / SIZE / BOX && pos1 % SIZE / BOX == pos2 % SIZE / BOX;
}