@component("errorController")
@Scope("view")
public class ErrorController
{
   public void forceStatusCode200()
   {
      FacesContext fc = FacesContext.getCurrentInstance();
      ExternalContext ec = fc.getExternalContext();
      HttpServletResponse hp = (HttpServletResponse) ec.getResponse();
      hp.setStatus(HttpServletResponse.SC_OK);
   }
}