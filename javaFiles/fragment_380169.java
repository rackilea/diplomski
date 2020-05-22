public void setPlayerGuess(String PlayerGuess1) {
    int PlayerGuess2 = Integer.parseInt(PlayerGuess1);
    PlayerGuess = PlayerGuess2;
    if(PlayerGuess2 >= 8) {
        System.out.println("enter number smaller than 8 ");
    }
}