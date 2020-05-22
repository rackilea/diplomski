List<User> getLoggedUsers() {
    Map<String,User> users = User.getUsers();
    return activeUsers.getUsers()
                      .stream()
                      .map(users::get)
                      .filter(Objects::nonNull)
                      .collect(Collectors.toList());
}