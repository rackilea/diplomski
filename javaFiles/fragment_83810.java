@Provider
public class CustomWriterInterceptor implements WriterInterceptor {

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) 
                throws IOException, WebApplicationException {

        OutputStream outputStream = context.getOutputStream();

        // Manipulate the HTTP entity using the OutputStream

        context.setOutputStream(outputStream);
        context.proceed();
    }
}