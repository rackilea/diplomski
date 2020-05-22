@ManagedBean @RequestScoped
public class Restlike {
  public void respond() {
   FacesContext context = FacesContext.getCurrentInstance();
   ExternalContext ext = context.getExternalContext();
   HttpServletResponse response = (HttpServletResponse) ext.getResponse();
   response.setContentType("text/plain; charset=UTF-8");
    try {
      PrintWriter pw = response.getWriter();
      pw.print("Hello, World!");
    } catch (IOException ex) {
      throw new FacesException(ex);
    }
    context.responseComplete();
  }
}