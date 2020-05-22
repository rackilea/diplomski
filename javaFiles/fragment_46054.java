import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NoNewLineFileInputStream extends FileInputStream {

    public NoNewLineFileInputStream(String filepath) throws FileNotFoundException {
        super(filepath);
    }

    public NoNewLineFileInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public NoNewLineFileInputStream(FileDescriptor filedescriptor) {
        super(filedescriptor);
    }

    @Override
    public int read(byte[] b) throws IOException {
        return this.read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int n = 0, c;
        do {
            c = this.read();
            if(c != -1) {
                b[off + n] = (byte) c;
                n++;
                len--;  
            } else {
                return c;
            }
        } while(c != -1 && len > 0);
        return n;
    }


    @Override
    public int read() throws IOException {
        int c;
        do {
            c = super.read();
        } while(c != -1 && (c == '\n' || c == '\r'));
        return c;
    }
}