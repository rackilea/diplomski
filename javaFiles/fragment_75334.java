public class ServletWrapper extends HttpServlet{
  private ServletDelegate fDelegate;
  //If this is false, the delegate does not work, and we should not forward anything to it.
  private boolean fAvailable = false;

  public ServletWrapper(){
    try{
      fDelegate = new ServletDelegate();
      fAvailable = true;
    } catch (NoClassDefFoundError e) {
      fAvailable = false;
    }
  }

  @Override
  protected void doPost( HttpServletRequest request, HttpServletResponse response )
      throws ServletException, IOException {
    if ( !fAvailable || fDelegate==null ) {
      response.sendError( HttpServletResponse.SC_SERVICE_UNAVAILABLE, LSP_MISSING_ERROR_MESSAGE );
      return;
    }

   fDelegate.doPost(request,response);
  }

}