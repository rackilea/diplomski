public void sortWinners() {
    for (int i = 0; i < 10; i++) {
        if (uScore < records[i].getScore()) {
            insertScoreHere = i;
            i = 10; //this is terrible i know
        }
    }

    for (int i = 9; i > insertScoreHere; i--) {
        records[i].setName(records[i-1].getName());  # EDIT 1 **
        records[i].setScore(records[i-1].getScore());# EDIT 2 **
    }

    records[insertScoreHere].setName(uName);
    records[insertScoreHere].setScore(uScore);
}