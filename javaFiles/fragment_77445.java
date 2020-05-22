for(int i = 0; i < nRanks; i++){

    for(int j = 0; j < nSuits; j++){

        deck[h] = new Card(i,j); // creation of the card
        h++; // adds 1 to to h so the program knows how many cards are there
    }
}