public enum Pitch {
    p60(60), p62(62), ...;

    private final int pitch;

    Pitch(int pitch) {
        this.pitch = pitch;
    }

    public int getValue() {
        return pitch;
    }
}