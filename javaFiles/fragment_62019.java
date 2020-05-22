public class MyWebAuthDets extends WebAuthenticationDetails {
  private final String parameter;
  public MyWebAuthDets(HttpServletRequest request) {
    super(request);
    this.parameter = request.getParameter("paramId");
  }
}