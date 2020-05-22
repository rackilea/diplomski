enum ABC {
    A('a'), B('b'), C('c');

    private char letter;

    private ABC(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
       return letter;
    }
}