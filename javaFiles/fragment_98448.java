if(currentPlayer == playerList.length) {
    for(int i = 0; i < playerList.length; i++) {
        if(playerList[i] == true) {
            currentPlayer = i;
            break;
        }
    }
}