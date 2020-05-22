public abstract class WebPage {
  // methods that each subclass needs to implement
  protected abstract String renderBodyHtml();
  public abstract String getNameToLinkTo();

  // other methods that are common to every page
  public final void serve(
      HttpServletRequest request, HttpServletResponse response) {
     // write the response, using the specific page's body HTML
     response.getWriter().println(renderToBodyHtml());
  }
}