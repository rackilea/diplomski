for (int i = 0; i < dices.length; i++) {
    if (dices[i] == NO_DICE) {
        continue;
    }
    if (dices[i] == 2 || dices[i] == 5) {
         dices[i] = NO_DICE;
         roundPoints = 0;
         //...
     }
}