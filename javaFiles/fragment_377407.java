public abstract class MyServletBase extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try {
      doGetInternal(req, resp);
    } catch (RuntimeException e) {
      handleError(e, req, resp);
    }
  }

  protected void handleError(RuntimeException e, HttpServletRequest req, HttpServletResponse resp) {
    // Error handling logic goes here
  }

  protected void doGetInternal(HttpServletRequest req, HttpServletResponse resp);

}