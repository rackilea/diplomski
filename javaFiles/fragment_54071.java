// how many ants? Just an example, change the value according to your needs
int nAnts = 8;
// how many doodlebugs? Just an example, change the value according to your needs
int nBugs = 2;

Random rand = new Random();

// place the ants
for (int i = 0; i < nAnts; i++) {
    int row, column;
    // get a random position that's not occupied
    do {
        row = rand.nextInt(size);
        column = rand.nextInt(size);
    } while (cells[row][column].isOccupied());

    // fill with ant
    cells[row][column].setInsect(Insect.ANT);
}

// place the doodlebugs
for (int i = 0; i < nBugs; i++) {
    int row, column;
    // get a random position that's not occupied
    do {
        row = rand.nextInt(size);
        column = rand.nextInt(size);
    } while (cells[row][column].isOccupied());

    // fill with doodlebug
    cells[row][column].setInsect(Insect.DOODLEBUG);
}