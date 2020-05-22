public class NewAction implements SessionAware {

  private Map theSession;
  private XXX xxx;

  public String execute() {
    Bean b = new Bean();
    b.setXXX(xxx);
    theSession.put(b);

    return "success";
  }

  public XXX getXXX() {
    return xxx;
  }

  public void setXXX(XXX xxx) {
    this.xxx = xxx;
  }

  public Map getSession() {
    return theSession;
  }

  public void setSession(Map session) {
    theSession = session;
  }
}