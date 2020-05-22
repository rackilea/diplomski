Random random = new Random();

for (int i = 0; i < amountTreasure; i++) {
    int treasureX, treasureY;

    do {
        treasureX = random.nextInt(n);
        treasureY = random.nextInt(m);
    } while (matrix[treasureX][treasureY] == 'X');

    matrix[treasureX][treasureY] = 'X';
}