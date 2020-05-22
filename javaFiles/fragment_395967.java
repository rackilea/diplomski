@ManagedBean(name = "securityMB")
@RequestScoped
public class SecurityBean {
  @ManagedProperty(value = "#{userManager}")
  private UserManager userManager;
  String loginURL = "/index.jsf";
  public void checkLogIn() {
  if (userManager == null || !userManager.isLoggedIn()) {
    FacesContext.getCurrentInstance().getExternalContext().redirect(loginURL);
  }
  //getter and setter (userManager)
}