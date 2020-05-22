import com.googlecode.htmlcompressor.compressor.Compressor;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.*;

@Provider
@HtmlMinify
public class MinifyHtmlInterceptor implements WriterInterceptor {

    @Inject
    private Compressor compressor;

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        final OutputStream outputStream = context.getOutputStream();
        context.setOutputStream(new HtmlMinifyOutputStream(outputStream, compressor));
        context.proceed();
    }
}