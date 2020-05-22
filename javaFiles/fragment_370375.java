public Game(int maxGuess, boolean gameOver) {
    super();
    maxGuess = maxGuess; //you can use this.maxGuess if compile failed
    gameOver = gameOver; //you can use this.gameOver if compile failed

    Random rand = new Random();
    RandomWord = Lexicon.getWord(rand.nextInt(9));
}