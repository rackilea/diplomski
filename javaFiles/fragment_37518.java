interface IUserProvider {
  User getUser(string userName);
  void saveUser(User user);
  User createUser(string userName, Email email);
  Email getUserEmail(string userName);
}