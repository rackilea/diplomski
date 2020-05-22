@XmlRootElement(name="UserContainer")
public class UserContainer {

  @XmlElement(name="users")
  private List<User> users;

  public UserContainer() {}

  public UserContainer(List<User> users) {
    super();
    this.users = users;
  }
  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}