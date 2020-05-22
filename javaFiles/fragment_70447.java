int[][] page = new int[3][3];
int count = 0;

for (int row = 0; row<3; ++row) {
    for (int column = 0; column < 3; ++column) {
        count++;
        page[row][column] = count;
    }
}