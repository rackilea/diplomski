/**
 * Purpose of this class is to wrap an input stream and close it automatically once the reading is complete.
 *
 * @author Rajind Ruparathna
 */
public class SelfClosingInputStream extends FilterInputStream {

    private static final int EOF = -1;

    private boolean isClosed = false;
    private Long length;
    private Long count = 0L;

    public SelfClosingInputStream(InputStream is, Long length) {
        super(is);
        this.length = length;
    }

    public SelfClosingInputStream(InputStream is) {
        super(is);
        length = -1L;
    }

    @Override
    public int read() throws IOException {
        try {
            if (!isClosed)  {
                int val = super.read();
                count = count + 1;
                if ((length != -1L && count.equals(length)) || val == EOF) {
                    close();
                    isClosed = true;
                }
                return val;
            } else {
                return EOF;
            }
        } catch (IOException e) {
            close();
            isClosed = true;
            throw e;
        }
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        try {
            if (!isClosed)  {
                int val = super.read(b, off, len);
                count = count + val;
                if ((length != -1L && count.equals(length)) || val == EOF) {
                    close();
                    isClosed = true;
                }
                return val;
            } else {
                return EOF;
            }
        } catch (IOException e) {
            close();
            isClosed = true;
            throw e;
        }
    }
}