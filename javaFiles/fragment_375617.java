public void quickSort () {
    Card temp1;
    int temp2;

    for (int x = 0 ; x < deck.length - 1 ; x++) //sort first length-1 values
    {
        int lowPos = x; // assume first value is lowest
        for (int y = x + 1 ; y < deck.length ; y++) // check rest of list
            if (deckNum [y] < deckNum [lowPos])
                lowPos = y; // make it the lowest

        temp1 = deck [x]; 
        deck [x] = deck [lowPos];
        deck [lowPos] = temp1;

        //Add the following to your code
        temp2 = deckNum [x]; 
        deckNum [x] = deckNum [lowPos];
        deckNum [lowPos] = temp2;
    }
}