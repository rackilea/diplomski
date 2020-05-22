public List <User> getUsers() {
    try {
        return UserDAO.getUsers();
    } catch (SomeException ex) {    // Not 'Exception' !
        // log the exception properly. Not a printStacktrace call!
        return new ArrayList<>();   // Not 'null'
    }
}