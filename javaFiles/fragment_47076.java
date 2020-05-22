public void addUser(User user) {
    users.add(user);
    // your index
    if (!usersByRole.containsKey(user.getRole()) {
       usersByRole.put(user.getRole(), new ArrayList<User>());
    }
    usersByRole.get(user.getRole()).add(user);
}

public List<User> findByRole(String role) {
    if (!usersByRole.containsKey(role)) {
        return Collectsions.emptyList();
    }
    return Collections.unmodifieableList(usersByRole.get(role));
}