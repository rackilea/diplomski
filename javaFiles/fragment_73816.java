List<User> users = userDAO.list();

if (!users.isEmpty()) {
    int count = users.size();
    // ...
}
else {
    // Help, no users?
}