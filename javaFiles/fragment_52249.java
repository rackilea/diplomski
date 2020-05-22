import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReplacerInputStream extends InputStream {

private static final byte[] REPLACEMENT = "amp;".getBytes();
    private final byte[] readBuf = new byte[REPLACEMENT.length];
    private final Deque<Byte> backBuf = new ArrayDeque<Byte>();
    private final InputStream in;

    public ReplacerInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        if (!backBuf.isEmpty()) {
            return backBuf.pop();
        }
        int first = in.read();
        if (first == '&') {
            peekAndReplace();
        }
        return first;
    }

    private void peekAndReplace() throws IOException {
        int read = super.read(readBuf, 0, REPLACEMENT.length);
        for (int i1 = read - 1; i1 >= 0; i1--) {
            backBuf.push(readBuf[i1]);
        }
        for (int i = 0; i < REPLACEMENT.length; i++) {
            if (read != REPLACEMENT.length || readBuf[i] != REPLACEMENT[i]) {
                for (int j = REPLACEMENT.length - 1; j >= 0; j--) {
                    // In reverse order
                    backBuf.push(REPLACEMENT[j]);
                }
                return;
            }
        }
    }

}