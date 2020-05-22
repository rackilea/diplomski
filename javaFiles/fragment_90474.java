import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;

/**
 * Created by TheConstructor for http://stackoverflow.com/a/24620470/1266906.
 */
public class MarkableFileReader extends Reader {
    /**
     * Cached instance of {@link java.math.BigInteger} of value
     * {@link Long#MAX_VALUE} (used in {@link #skip(java.math.BigInteger)})
     */
    public static final BigInteger LONG_MAX_VALUE                    = BigInteger.valueOf(Long.MAX_VALUE);
    /**
     * Default value of {@link #reopenOnResetThreshold} (10 MiB)
     */
    public static final int        DEFAULT_REOPEN_ON_RESET_THRESHOLD = 10 * 1024 * 1024;
    /**
     * Initialize the line-reading-buffer to this size
     */
    public static final int        EXPECTED_LINE_LENGTH              = 80;

    private final File           file;
    private final Charset        charset;
    private       BufferedReader reader;
    private       BigInteger     readCharacters;
    private       BigInteger     mark;
    private       boolean        reopenOnReset;
    private final int            reopenOnResetThreshold;
    private final BigInteger     reopenOnResetThresholdBI;
    /**
     * {@link java.io.BufferedReader#readLine()} is implemented to skip the
     * {@code '\n'} of an {@code "\r\n"} only with the next read. The same
     * behaviour is implemented here.
     */
    private       boolean        skipLf;
    private       boolean        skipLfMark;

    public MarkableFileReader(String fileName) throws FileNotFoundException {
        this(fileName, null);
    }

    public MarkableFileReader(String fileName, Charset charset) throws FileNotFoundException {
        this(fileName, charset, DEFAULT_REOPEN_ON_RESET_THRESHOLD);
    }

    public MarkableFileReader(String fileName, Charset charset, int reopenOnResetThreshold)
            throws FileNotFoundException {
        this(new File(fileName), charset, reopenOnResetThreshold);
    }

    public MarkableFileReader(File file) throws FileNotFoundException {
        this(file, null, DEFAULT_REOPEN_ON_RESET_THRESHOLD);
    }

    public MarkableFileReader(File file, Charset charset, int reopenOnResetThreshold) throws FileNotFoundException {
        super();
        this.file = file;
        this.charset = charset;
        this.mark = null;
        this.skipLfMark = false;
        this.reopenOnReset = false;
        this.reopenOnResetThreshold = Math.max(0, reopenOnResetThreshold);
        this.reopenOnResetThresholdBI = BigInteger.valueOf(this.reopenOnResetThreshold);
        initReader();
    }

    private void initReader() throws FileNotFoundException {
        final FileInputStream fileInputStream = new FileInputStream(file);
        final InputStreamReader inputStreamReader = (charset == null) ?
                                                    new InputStreamReader(fileInputStream) :
                                                    new InputStreamReader(fileInputStream, charset);
        reader = new BufferedReader(inputStreamReader);
        this.readCharacters = BigInteger.ZERO;
        this.reopenOnReset = true;
        this.skipLf = false;
    }

    private void incrementReadCharacters() {
        this.readCharacters = this.readCharacters.add(BigInteger.ONE);
    }

    private void incrementReadCharacters(final long characters) {
        if(characters != -1) {
            this.readCharacters = this.readCharacters.add(BigInteger.valueOf(characters));
        }
    }

    @Override
    public int read() throws IOException {
        synchronized (lock) {
            final int read = reader.read();
            if (read != -1) {
                incrementReadCharacters();
            }
            if (skipLf && read == '\n') {
                skipLf = false;
                return read();
            }
            return read;
        }
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        synchronized (lock) {
            if ((off < 0) || (len < 0) ||
                    ((off + len) > cbuf.length) || ((off + len) < 0)) {
                throw new IndexOutOfBoundsException();
            } else if (len == 0) {
                return 0;
            }
            if(skipLf) {
                int firstChar = read();
                if (firstChar == -1) {
                    return 0;
                }
                cbuf[off] = (char) firstChar;
                if (len > 1) {
                    final int read = reader.read(cbuf, off + 1, len - 1);
                    incrementReadCharacters(read);
                    return read + 1;
                } else {
                    return 1;
                }
            } else {
                final int read = reader.read(cbuf, off, len);
                incrementReadCharacters(read);
                return read;
            }
        }
    }

    /**
     * Reads a line of text.  A line is considered to be terminated by any one
     * of a line feed ('\n'), a carriage return ('\r'), or a carriage return
     * followed immediately by a linefeed.
     * <p>Note: this is not directly proxied to
     * {@link java.io.BufferedReader#readLine()} as we need to know how many
     * characters compose the line-ending for {@link #getReadCharacters()} to
     * return correct numbers</p>
     *
     * @return A String containing the contents of the line, not including
     * any line-termination characters, or null if the end of the
     * stream has been reached
     * @throws IOException
     *         If an I/O error occurs
     * @see java.nio.file.Files#readAllLines(java.nio.file.Path, java.nio.charset.Charset)
     * @see java.io.BufferedReader#readLine()
     */
    public String readLine() throws IOException {
        synchronized (lock) {
            final CharArrayWriter charArrayWriter = new CharArrayWriter(EXPECTED_LINE_LENGTH);
            int lastRead = read();
            if(lastRead == -1) {
                return null;
            }
            while (lastRead != -1 && lastRead != '\r' && lastRead != '\n') {
                charArrayWriter.write(lastRead);
                lastRead = read();
            }
            if(lastRead == '\r') {
                skipLf = true;
            }
            return charArrayWriter.toString();
        }
    }

    @Override
    public long skip(long n) throws IOException {
        if (n < 0L) {
            throw new IllegalArgumentException("skip value is negative");
        }
        if(n == 0L) {
            return 0L;
        }
        synchronized (lock) {
            if(skipLf) {
                int read = read();
                if (read == -1) {
                    return 0;
                }
                final long skip = reader.skip(n - 1);
                incrementReadCharacters(skip);
                return skip + 1;
            } else {
                final long skip = reader.skip(n);
                incrementReadCharacters(skip);
                return skip;
            }
        }
    }

    @Override
    public boolean ready() throws IOException {
        synchronized (lock) {
            return reader.ready();
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public void mark(int readAheadLimit) throws IOException {
        if(readAheadLimit < 0) {
            throw new IllegalArgumentException("readAheadLimit needs to be 0 or greater");
        }
        synchronized (lock) {
            mark = readCharacters;
            skipLfMark = skipLf;
            reopenOnReset = false;
            if (reader.markSupported()) {
                if (readAheadLimit >= reopenOnResetThreshold) {
                    reader.mark(reopenOnResetThreshold);
                } else {
                    reader.mark(readAheadLimit);
                }
            }
        }
    }

    @Override
    public void reset() throws IOException {
        synchronized (lock) {
            if (mark == null) {
                throw new IOException("call mark() first");
            }
            final BigInteger readSinceMark = readCharacters.subtract(mark);
            if (reopenOnReset ||
                    readSinceMark.compareTo(reopenOnResetThresholdBI) >= 0 ||
                    !reader.markSupported()) {
                if (!reopenAt(mark)) {
                    throw new IOException("reopening at position failed");
                }
            } else {
                reader.reset();
                readCharacters = mark;
            }
            skipLf = skipLfMark;
        }
    }

    @Override
    public void close() throws IOException {
        synchronized (lock) {
            reader.close();
        }
    }

    public BigInteger getReadCharacters() {
        synchronized (lock) {
            return readCharacters;
        }
    }

    public boolean reopenAt(final BigInteger position) throws IOException {
        synchronized (lock) {
            if (reader != null) {
                reader.close();
            }
            initReader();
            BigInteger skip = skip(position);
            return skip.equals(position);
        }
    }

    public BigInteger skip(final BigInteger n) throws IOException {
        synchronized (lock) {
            BigInteger remaining = n;
            while (remaining.compareTo(BigInteger.ZERO) > 0) {
                long skip = skip(remaining.min(LONG_MAX_VALUE).longValue());
                remaining = remaining.subtract(BigInteger.valueOf(skip));
                if (skip < 1) {
                    break;
                }
            }
            return n.subtract(remaining);
        }
    }
}