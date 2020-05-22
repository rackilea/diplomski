public class LoginAction extends ActionSupport implements SessionAware, Preparable {
  List<UserData> users = new ArrayList<UserData>();
  private Map<String, Object> session;

  /**
   * Field to store username.
   */
  private String username;


  public String getUsername() { return username; }

  public void setUsername(String username) { this.username = username; }

  /**
   * Field to store password.
   */
  private String password;

  public String getPassword() { return password; }

  public void setPassword(String password) { this.password = password; }

  @Override
  public void setSession(Map<String, Object> session){ this.session = session; }

  @Override
  public void prepare() throws Exception {
    addUser("SeyCC", "loop"); 
  }


  public String execute() {

    if (!users.get(0).getUsername().equals(username) || !users.get(0).getPassword().equals(password))
       return ERROR;

    session.put("user", users.get(0).getUsername());

    return SUCCESS;
  }

  //@param username, password
  public void addUser(String username, String password) {
    users.add(new UserData(username, password));
  }
}