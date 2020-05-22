package cipher;

public final class Range {

    public final char min;
    public final char max;
    public final int size;

    public static Range inclusive(char min, char max) {
        return new Range(min, max);
    }

    Range(char min, char max) {
        this.min = min;
        this.max = max;
        size = max - min + 1;
    }

    /** Shift c up by i places, wrapping around to the
     * beginning of the range when it reaches the end. */
    public char shift(char c, int i) {
        return (char) (min + mod(c - min + i, size));
    }

    /** x mod a */
    static int mod(int x, int a) {
        return ((x % a) + a) % a;
    }
}