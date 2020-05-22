import com.googlecode.htmlcompressor.compressor.Compressor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HtmlMinifyOutputStream extends ByteArrayOutputStream {

    private OutputStream origOut;
    private Compressor compressor;

    public HtmlMinifyOutputStream(OutputStream origOut, Compressor compressor) {
        this.origOut = origOut;
        this.compressor = compressor;
    }

    public void close() throws IOException {
        super.close();
        String compressedBody = compressor.compress(new String(this.buf));
        this.origOut.write(compressedBody.getBytes());
        this.origOut.close();
    }
}