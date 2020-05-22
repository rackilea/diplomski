Map<String, User> idTable = new HashMap<String, User>();
User bob = new User("Bob");
idTable.put(bob.getId(), bob);

public User findUser(String id) {
  return idTable.get(id);
}