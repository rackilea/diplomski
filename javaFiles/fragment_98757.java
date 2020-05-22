public class RequestLogPost {

  public static class PostHandler extends ContextHandler {
    public PostHandler() {
      setContextPath("/app");
      // setAllowNullPathInfo(true); // enable to see difference in request handling
    }

    @Override
    public void doHandle(String target, Request baseRequest, HttpServletRequest request,
        HttpServletResponse response) throws IOException, ServletException {
      System.out.println(request.getMethod());
      response.setStatus(HttpStatus.OK_200);
      baseRequest.setHandled(true);
    }
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(5555);

    HandlerCollection handlers = new HandlerCollection();
    handlers.addHandler(new PostHandler());
    handlers.addHandler(new DefaultHandler());
    handlers.addHandler(createRequestLogHandler());

    server.setHandler(handlers);

    server.start();
    server.join();
  }

  private static RequestLogHandler createRequestLogHandler() {
    final int RETAIN_FOREVER = 0; // see RolloverFileOutputStream, 0 == forever.
    RequestLogHandler logHandler = new RequestLogHandler();

    NCSARequestLog ncsaRequestLog = new AsyncNCSARequestLog("requests.log");
    ncsaRequestLog.setAppend(true);
    ncsaRequestLog.setExtended(true);
    ncsaRequestLog.setLogTimeZone("GMT");
    ncsaRequestLog.setRetainDays(RETAIN_FOREVER);
    logHandler.setRequestLog(ncsaRequestLog);
    return logHandler;
  }
}