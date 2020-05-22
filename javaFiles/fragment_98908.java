import com.googlecode.htmlcompressor.compressor.Compressor;
import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import org.glassfish.hk2.api.Factory;

public class HtmlCompressorFactory implements Factory<Compressor> {

    private HtmlCompressor compressor;

    @Override
    public Compressor provide() {
        if(compressor == null) {
            compressor = new HtmlCompressor();
        }
        compressor.setCompressJavaScript(true);
        compressor.setCompressCss(true);
        return compressor;
    }

    @Override
    public void dispose(Compressor compressor) {}
}