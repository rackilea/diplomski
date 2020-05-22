private static boolean wins(int amount){
    if (amount < 0 ) {
        return true;  // game already over, previous player lost
    } else if ( amount <= 1){
        return false; // you loose always
    } else {
        // we win if the opponent doesn't
        return  wins(amount-5) == false ||
                wins(amount-3) == false ||
                wins(amount-2) == false;
    }
}