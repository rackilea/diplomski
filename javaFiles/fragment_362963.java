List<User> users = new List<User>();
users.add(new User("Bob"));
users.add(new User("Steve"));
users.ass(new User("Ann"));

public User findUser(String id) {
  Iterator<User> index = users.iterator();
  while (index.hasNext()) {
    User user = index.next();
    if (id.equals(user.getId())) {
      return user;
    }
  }
  return null;
}