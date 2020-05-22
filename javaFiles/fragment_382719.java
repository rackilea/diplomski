boolean mineLocations[][] = new boolean[rows][cols];
Random random = new Random();

int counter = 0;
while (counter < 3) { //looping while 3 distinct cells are not set to true
    int rRow = random.nextInt(rows);
    int rCol = random.nextInt(cols);

    if (!mineLocations[rRow][rCol]) {
        mineLocations[rRow][rCol] = true;
        counter++; //increasing the counter only when a new cell is set to true
    }
}