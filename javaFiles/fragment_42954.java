static class MyHttpServletResponseWrapper 
  extends HttpServletResponseWrapper {

  private StringWriter sw = new StringWriter(BUFFER_SIZE);

  public MyHttpServletResponseWrapper(HttpServletResponse response) {
    super(response);
  }

  public PrintWriter getWriter() throws IOException {
    return new PrintWriter(sw);
  }

  public ServletOutputStream getOutputStream() throws IOException {
    throw new UnsupportedOperationException();
  }

  public String toString() {
    return sw.toString();
  }
}