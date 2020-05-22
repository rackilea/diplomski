public static boolean hasEvenStraight(Card [] cards) {  

    int low = 20; // There is no 20 card.
    int high = 0; // There is no 0 card.

    // This array is a bit wasteful as it won't all be used,
    // but it's straightforward this way.

    boolean[] alreadyThere = new boolean[15];

    for(int i = 0; i<cards.length; i++){
        Card myCard = cards[i];
        int currValue = myCard.getValue();

        // Handle ace. If it's 1 it's not an
        // even hand anyway, so assume it's 14.
        if ( currValue == 1 ) {
           currValue = 14;
        }

        // If any card is not even, this is not an Even Straight.
        if(currValue%2 != 0){
            return false;
        }

        // We have two cards of the same number
        // (E.g. 2 of spades and 2 of hearts). So
        // not a straight.
        if ( alreadyThere[currValue] ) {
           return false;
        }
        alreadyThere[currValue] = true;

        // To get the lowest and highest, compare each value to
        // existing lowest and highest and change them accordingly.
        if ( currValue > high ) {
           high = currValue;
        }
        if ( currValue < low ) {
           low = currValue;
        }
    }

    // Loop finished. All the numbers are even, now check if they
    // are consecutive.
    return ( high - low ) == 8;
}