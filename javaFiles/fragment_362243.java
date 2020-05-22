static final int[][] naybors = {
    { 0, 1 },
    { 0, -1 },
    { 1, 0 },
    { -1, 0 },
};

boolean isFinished = false;
for (int[] nb : naybors) {
    if (drawArray[ROW + nb[0]][COL + nb[1]] == ' '
            && drawArray[ROW + 2*nb[0]][COL + 2*nb[1]] == 'E') {
        move(ROW, COL, ROW + 2*nb[0], COL + 2*nb[1);
        isFinished = true;
        break;
    }
}