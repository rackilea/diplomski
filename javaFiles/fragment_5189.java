import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/** An attempt for:
 * http://stackoverflow.com/questions/35817251/draw-data-from-inputstream-every-fixed-byte-length
 *  <b>This class is NOT thread safe.</b>
 * Created by kmhaswade on 3/5/16.
 */
public class InputStreamIterator extends BufferedInputStream implements Iterator<byte[]> {

    private final InputStream in;
    private final byte[] bytes;
    private int bytesRead;
    /**
     * Returns a buffered input stream that "iterates" over a given stream. Follows the decorator pattern.
     * @param in the input stream that should be buffered
     * @param n
     */
    public InputStreamIterator(InputStream in, int n) {
        super(in);
        this.in = in;
        if (n <=0 || n > Integer.MAX_VALUE)
            throw new IllegalArgumentException("illegal value: " + n);
        bytes = new byte[n];
    }

    @Override
    public boolean hasNext() {
        try {
            bytesRead = super.read(this.bytes);
            if (bytesRead == -1) {
                this.close();
                return false;
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e); // could be handled better ...
        }
    }

    @Override
    public byte[] next() {
        if (bytes.length == bytesRead)
            return bytes;
        else
            return Arrays.copyOf(bytes, bytesRead);
    }

    @Override
    public void remove() {
        throw new RuntimeException("no way to push back yet");
    }

    @Override
    public void forEachRemaining(Consumer<? super byte[]> action) {
        throw new RuntimeException("not yet implemented");
    }

    public static void main(String[] args) {
        InputStreamIterator itIn = new InputStreamIterator(System.in, 50);
        while (itIn.hasNext()) {
            byte[] bs = itIn.next();
            for (byte b : bs) {
                System.out.println("byte read: " + b);
            }
        }
    }
}