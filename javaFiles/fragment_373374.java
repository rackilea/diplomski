public final class Word {
    private int count;
    private final String text;

    public Word(String text) {
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public int incrementCount() {
        return ++count;
    }

    public String getText() {
        return text;
    }
}