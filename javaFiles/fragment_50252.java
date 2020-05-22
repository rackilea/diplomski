import java.io.IOException;
import java.io.InputStream;

/**
* Replaces numerical entities with their notation as text.
*/
public class AmpersandingStream extends InputStream {

    private InputStream in;
    private boolean justReadAmpersand;
    private String lookAhead = "";

    public AmpersandingStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        if (!lookAhead.isEmpty()) {
            int c = lookAhead.codePointAt(0);
            lookAhead = lookAhead.substring(Character.charCount(c));
            return c;
        }
        int c = in.read();
        if (c == (int)'#' && justReadAmpersand) {
            c = (int)'a';
            lookAhead = "mp;#";
        }
        justReadAmpersand = c == (int)'&';
        return c;
    }

    @Override
    public int available() throws IOException {
        return in.available();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
    }

    @Override
    public boolean markSupported() {
        return in.markSupported();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return in.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return in.read(b, off, len);
    }

    @Override
    public synchronized void reset() throws IOException {
        in.reset();
    }

    @Override
    public long skip(long n) throws IOException {
        return in.skip(n);
    }

}