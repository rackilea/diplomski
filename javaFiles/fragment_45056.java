public interface MyUser {
  // all the methods you need
  String getSurname();
}

public class ExternalUser implements MyUser {
  private User _user;
  private ExternalUser() { }
  public ExternalUser(User u) {
    this._user = u;
  }
  public String getSurname() {
    return _user.getSurname();
  }
}

public class BrandNewUser implements MyUser {
  private String _surname;
  public ExternalUser(String name, String surname) {
    this._surname = surname;
  }
  public String getSurname() {
    return _surname;
  }
}