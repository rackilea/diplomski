private ArrayList<User> users= new ArrayList<User>(); // list of users

public User createUser(String name, String address) {
    User u = new User(name, address);
    users.add(u);
    return u;
}