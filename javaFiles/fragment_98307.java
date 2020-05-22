public class CompressionResponseWrapper extends HttpServletResponseWrapper {
  protected ServletOutputStream stream = null;
  protected PrintWriter writer = null;
  protected int threshold = 0;
  protected HttpServletResponse origResponse = null;
  public CompressionResponseWrapper(HttpServletResponse response) {
super(response);
origResponse = response;
  }
  public void setCompressionThreshold(int threshold) {
this.threshold = threshold;
  }
  public ServletOutputStream createOutputStream() throws IOException {
return (new CompressionResponseStream(origResponse));
  }
  public ServletOutputStream getOutputStream() throws IOException {
if (writer != null) {
  throw new IllegalStateException("getWriter() has already been " +
                                  "called for this response");
}
if (stream == null) {
  stream = createOutputStream();
}
((CompressionResponseStream) stream).setCommit(true);
((CompressionResponseStream) stream).setBuffer(threshold);
return stream;
  }
  public PrintWriter getWriter() throws IOException {
if (writer != null) {
  return writer;
}
if (stream != null) {
  throw new IllegalStateException("getOutputStream() has already " +
                                  "been called for this response");
}
stream = createOutputStream();
((CompressionResponseStream) stream).setCommit(true);
((CompressionResponseStream) stream).setBuffer(threshold);
writer = new PrintWriter(stream);
return writer;
  }
}