public User getUserByID(int userID) {
    return getUser(user -> user.getID() == userID);
}

public User getUserByUsername(String username) {
    return getUser(user -> user.getUsername().equals(username));
}

private User getUser(Predicate<User> predicate) {
    ListIterator<User> listIterator = listOfLoggedInUsers.listIterator();
    User user;
    while(listIterator.hasNext()) {
        user = listIterator.next();
        if (predicate.test(user)) {
            return user;
        }
    }
    return null;
}