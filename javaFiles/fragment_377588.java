public static int switchPlayer(int currentPlayer, boolean[] playerList) {
    // if the current player + 1 = length (size) of array,
    // start back at the beginning and find the first player still playing
    if(currentPlayer + 1 == playerList.length) {
        for(int i = 0; i < playerList.length; i++) {
            if(playerList[i] == true) {    // if player is still in the game
                currentPlayer = i;         // currentPlayer = current index of array
                break;
            }
        }
    }
    // otherwise the current player number + 1 is not at the end of the array
    // i.e. it is less than the length (size) of the array, so find the next player
    // still playing
    else {
        for(int i = (currentPlayer+1); i < playerList.length; i++) {
            if(playerList[i] == true) {
                currentPlayer = i;
                break;
            }
        }
    }
    return currentPlayer;
}