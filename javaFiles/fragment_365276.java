private ArrayList<User> users; // list of users

public User createUser(String name, String address) {

    User u = new User(name, address);
    users = new ArrayList<User>();

    users.add(u);

    return u;
}