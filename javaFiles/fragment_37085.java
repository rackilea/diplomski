@Provider
public class GzipReaderInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)  throws IOException, WebApplicationException {
        if ("gzip".equals(context.getHeaders().get("Content-Encoding"))) {
            InputStream originalInputStream = context.getInputStream();
            context.setInputStream(new GZIPInputStream(originalInputStream));
        }
        return context.proceed();
    }

}