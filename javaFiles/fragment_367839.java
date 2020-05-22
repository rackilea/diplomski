public static void main(String[] args) {
    GuessWord g1 = new GuessWord();
    boolean completed = false;
    while (!completed) {
        g1.letter = g1.getLetter();
        completed = g1.calc();
    }
}