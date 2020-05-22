User user = userDAO.find(username, password);

if (user != null) {
    // Proceed with login?
} else {
    // Show error?
}