public int getWordCountInParallel() {
    return str.codePoints().parallel()
        .collect(WordCountState::new, WordCountState::accumulate, WordCountState::combine)
        .getResult();
}


public class WordCountState {
    private boolean firstSpace, lastSpace=true, initial=true;
    private int counter;

    public void accumulate(int character) {
        boolean white=Character.isWhitespace(character);
        if(lastSpace && !white) counter++;
        lastSpace=white;
        if(initial) {
            firstSpace=white;
            initial=false;
        }
    }
    public void combine(WordCountState b) {
        if(initial) {
            this.initial=b.initial;
            this.counter=b.counter;
            this.firstSpace=b.firstSpace;
            this.lastSpace=b.lastSpace;
        }
        else if(!b.initial) {
            this.counter += b.counter;
            if(!lastSpace && !b.firstSpace) counter--;
            this.lastSpace = b.lastSpace;
        }
    }
    public int getResult() {
        return counter;
    }
}