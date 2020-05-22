public class JettyNoStacktraceHttpBinding extends JettyRestHttpBinding {

    private static final int BAD_REQUEST = 400;

    @Override
    public void doWriteExceptionResponse(Throwable exception, javax.servlet.http.HttpServletResponse response) throws java.io.IOException {
        if (exception instanceof JsonParseException) {
            response.setStatus(BAD_REQUEST);

            response.setContentType("text/plain");
            PrintWriter pw = response.getWriter();
            pw.print(exception.getMessage());
            pw.flush();
        }
    }

}


<restConfiguration contextPath="/some/path" component="jetty" scheme="http" host="0.0.0.0" port="8282" bindingMode="json">
    <endpointProperty key="httpBindingRef" value="jettyNoStackTraceHTTPBinding" />
<!-- ... -->
</restConfiguration>