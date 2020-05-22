class UserProvider {
  IUserDatabaseReader userReader;
  IUserDatabaseWriter userWriter;

    // Constructor
    public UserProvider (IUserDatabaseReader userReader, 
          IUserDatabaseWriter userWriter) {
      this.userReader = userReader;
      this.userWriter = userWriter;
    }

  public User getUser(string userName) {
    return this.userReader.readUser(username);
  }

  public void saveUser(User user) {
    return this.userWriter.updateUser(user);
  }

  public User createUser(string userName, Email email) {
    User newUser = new User(userName, email);
    this.userWriter.createUser(newUser);
    return newUser;
  }

  public Email getUserEmail(string userName) {
    return this.userReader.readUserEmail(userName);
  }
}