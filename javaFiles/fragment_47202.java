public Optional<User> getUser() {
    try {
        return Optional.of(UserDAO.getUser());
    } catch (SomeException ex) {
        // log the exception 
        return Optional.empty();
    }
}