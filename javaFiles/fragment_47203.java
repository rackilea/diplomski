public static final User NO_USER = new User();  // preferably immutable!

public User getUser() {
    try {
        return UserDAO.getUser();
    } catch (SomeException ex) {
        // log the exception 
        return NO_USER;
    }
}