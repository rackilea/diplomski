if ( prizeIs == chosenDoor ) { // Note it's an if, not a while.
    boolean chooseFirstZonk = Math.random() < 0.5; // 50% chance
    switch ( prizeIs ) {
        case 1:
            if ( chooseFirstZonk ) {
                 zonkIs = 2;
            } else {
                 zonkIs = 3;
            }
            break;
        case 2:
            if ( chooseFirstZonk ) {
                 zonkIs = 1;
            } else {
                 zonkIs = 3;
            }
            break;
        case 3:
            if ( chooseFirstZonk ) {
                 zonkIs = 1;
            } else {
                 zonkIs = 2;
            }
            break;
    }
}