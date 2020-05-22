import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MultiXMLDocReader extends Reader {
    private BufferedReader reader;
    private String buffer;
    private int bufferPos;
    private boolean firstDocument;
    private boolean realEOF;
    private boolean enforceEOF;

    public MultiXMLDocReader(Reader reader) {
        this.reader = new BufferedReader(reader);
        firstDocument = true;
        buffer = "";
        bufferPos = 0;
        realEOF = enforceEOF = false;
    }

    @Override
    public void close() throws IOException {
        enforceEOF = false;
        if (realEOF) reader.close();
    }

    @Override
    public int read() throws IOException {
        char[] buffer = new char[1];
        int result = read(buffer, 0, 1);
        if (result < 0) return -1;
        return buffer[0];
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (enforceEOF) return -1;
        int lenLeft = len;
        int read = 0;
        while (lenLeft > 0) {
            if (buffer.length()>0) {
                char[] lbuffer = buffer.toCharArray();
                int bufLen = buffer.length() - bufferPos;
                int newBufferPos = 0;
                if (lenLeft < bufLen) {
                    bufLen = lenLeft;
                    newBufferPos = bufferPos + bufLen;
                }
                else buffer = "";
                System.arraycopy(lbuffer, bufferPos, cbuf, off, bufLen);
                read += bufLen;
                lenLeft -= bufLen;
                off += bufLen;
                bufferPos = newBufferPos;
                continue;
            }
            buffer = reader.readLine();
            if (buffer == null) {
                realEOF = true;
                enforceEOF = true;
                return (read == 0 ? -1 : read);
            }
            else
                buffer += "\n";
            if (buffer.startsWith("<?xml")) {
                if (firstDocument) firstDocument = false;
                else {
                    enforceEOF = true;
                    return (read == 0 ? -1 : read);
                }
            }
        }
        return read;
    }
}