import java.util.Arrays;
import java.util.Iterator;

public class BruteForceIterator implements Iterator<String> {

    private char min, max;

    private char[] current;

    private char[] last;

    private int reachedLast = 0;

    public BruteForceIterator(char min, char max, int length) {
        this.min = min;
        this.max = max;
        current = new char[length];
        Arrays.fill(current, min);
        last = new char[length];
        Arrays.fill(last, max);
    }

    @Override
    public boolean hasNext() {
        return reachedLast < 2;
    }

    @Override
    public String next() {
        String str = new String(current);
        for(int i = current.length - 1; i >= 0; i--) {
            char next = following(current[i]);
            current[i] = next;
            if (next != min) {
                break;
            }
        }
        if (Arrays.equals(current, last) || reachedLast > 0) {
            reachedLast++;
        }
        return str;
    }

    private char following(char in) {
        if (in < max) {
            return (char) (in + 1);
        } else {
            return min;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("No with me, sir!");
    }

    public static void main(String[] args) {
        BruteForceIterator bit = new BruteForceIterator('a', 'c', 3);
        while (bit.hasNext()) {
            System.out.println(bit.next());
        }
    }
}