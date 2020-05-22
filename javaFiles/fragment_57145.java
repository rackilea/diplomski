public int getWordCountInParallel() {
    return str.codePoints().parallel()
        .mapToObj(WordCountState::new)
        .reduce(WordCountState::new)
        .map(WordCountState::getResult).orElse(0);
}


public class WordCountState {
    private final boolean firstSpace, lastSpace;
    private final int counter;

    public WordCountState(int character){
        firstSpace = lastSpace = Character.isWhitespace(character);
        this.counter = 0;
    }

    public WordCountState(WordCountState a, WordCountState b) {
        this.firstSpace = a.firstSpace;
        this.lastSpace = b.lastSpace;
        this.counter = a.counter + b.counter + (a.lastSpace && !b.firstSpace? 1: 0);
    }
    public int getResult() {
        return counter+(firstSpace? 0: 1);
    }
}