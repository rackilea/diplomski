ArrayList<User> userGroup = new ArrayList<>();
// User userOne;
public UserGroup()
{
  addUser(new User("LeeB123", "Staff", "Lee"));
  addUser(new User("XLeeB123", "XStaff", "XLee"));
  addUser(new User("XXLeeB123", "XXStaff", "XXLee"));
}

public void addUser(User inUser)
{
  //userGroup.add(new User("LeeB123", "Staff", "Lee"));
  userGroup.add(inUser);
}
public ArrayList<User> getUserGroup() {
    return userGroup;
}