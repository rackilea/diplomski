class Phrase {
    private final String start;
    private final String middle;
    private final String end;

    public Phrase(String initial) {
        String[] words = initial.split(" ");
        start = words[0];
        middle = Arrays.stream(words, 1, words.length).collect(joining(" "));
        end = words[words.length - 1];
    }

    public boolean matches(Phrase other) {
        this.end.equals(other.start);
    }

    public String combine(Phrase other) {
        assert matches(other);
        return Stream.of(this.start, this.middle, this.end, other.middle, other.end)
            .collect(joining(" "));
    }
}