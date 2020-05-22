public void sortWinners() {
    for (int i = 0; i < 10; i++) {
        if (uScore < records[i].getScore()) {
            insertScoreHere = i;
            i = 10; //this is terrible i know
        }
    }

    # EDIT 1: lets save this record for reuse
    playerRecord temp = records[9]; 
    for (int i = 9; i > insertScoreHere; i--) {
        records[i] = records[i-1];
    }

    # EDIT 2: change the record to point to a separate record
    records[insertScoreHere] = temp; 
    # ^ this index now points to a separate record from records[i] 
    records[insertScoreHere].setName(uName);
    records[insertScoreHere].setScore(uScore);
}