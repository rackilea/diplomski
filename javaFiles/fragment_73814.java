User user = userDAO.find(username, password);

if (user != null) {
    // Login?
}
else {
    // Show error?
}