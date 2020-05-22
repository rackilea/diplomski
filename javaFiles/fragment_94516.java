private void calculateNextMoveRandom() {
    Random rand = new Random();

    int randomRow;
    int randomColumn;

    while (true) {
        randomRow = rand.nextInt(3);
        randomColumn = rand.nextInt(3);

        if (Constants.EMPTY == board[randomRow][randomColumn]) {
            rowOfResult = randomRow;
            columnOfResult = randomColumn;
            return;
        }
    }
}