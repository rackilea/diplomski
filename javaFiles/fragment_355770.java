import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

public class LineReadingOutputStream extends OutputStream {

    private static final byte CR = '\r';
    private static final byte LF = '\n';

    private final Consumer<String> consumer;
    private final StringBuilder stringBuilder = new StringBuilder();
    private boolean lastCR = false;

    private LineReadingOutputStream(final Consumer<String> consumer) {
        this.consumer = Objects.requireNonNull(consumer);
    }

    @Override
    public void write(final int b) throws IOException {
        write(new byte[]{(byte) b});
    }

    @Override
    public void write(final byte[] b, int start, final int len) {
        if (b == null) {
            throw new NullPointerException();
        }
        if (len < 0) {
            throw new IllegalArgumentException();
        }
        final int end = start + len;
        if ((start < 0) || (start > b.length) || (end < 0) || (end > b.length)) {
            throw new IndexOutOfBoundsException();
        }

        if (this.lastCR && start < end && b[start] == LF) {
            start++;
            this.lastCR = false;
        } else if (start < end) {
            this.lastCR = b[end - 1] == CR;
        }

        int base = start;
        for (int i = start; i < end; i++) {
            if (b[i] == LF || b[i] == CR) {
                final String chunk = asString(b, base, i);
                this.stringBuilder.append(chunk);
                consume();
            }
            if (b[i] == LF) {
                base = i + 1;
            } else if (b[i] == CR) {
                if (i < end - 1 && b[i + 1] == LF) {
                    base = i + 2;
                    i++;
                } else {
                    base = i + 1;
                }
            }
        }
        final String chunk = asString(b, base, end);
        this.stringBuilder.append(chunk);
    }

    @Override
    public void close() {
        if (this.stringBuilder.length() != 0) {
            consume();
        }
    }

    private static String asString(final byte[] b, final int start, final int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        if (start == end) {
            return "";
        }
        final byte[] copy = Arrays.copyOfRange(b, start, end);
        return new String(copy, StandardCharsets.UTF_8);
    }

    private void consume() {
        this.consumer.accept(this.stringBuilder.toString());
        this.stringBuilder.delete(0, Integer.MAX_VALUE);
    }
}