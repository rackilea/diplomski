User user = userDAO.find(username, password);
if (user != null) {
    request.getSession().setAttribute("user", user);
} else {
    // Show error?
}