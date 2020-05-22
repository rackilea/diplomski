int curNumber = 6;
    int nextNumber = 0;
    int movesInc = (nextNumber - curNumber) + 1
                    + ((nextNumber > curNumber)? 0: 11);
    int movesDec = (curNumber - nextNumber) + 1
                    + ((nextNumber < curNumber)? 0: 11);