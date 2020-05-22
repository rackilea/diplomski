List<User> getLoggedUsers() {
    Map<String,User> users = User.getUsers();
    List<User> onlineUsers = new ArrayList<>();
    for (String username : activeUsers.getUsers()) {
        User user = users.get(username);
        if(user != null) {
            onlineUsers.add(user);
        }
    }
    return onlineUsers;
}