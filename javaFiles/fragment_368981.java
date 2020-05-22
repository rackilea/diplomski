User user = (User) request.getSession().getAttribute("user");
if (user != null) {
    // User is logged in.
} else {
    // User is not logged in!
}