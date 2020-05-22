Integer userid = (Integer) session.getAttribute("user");
User user = null;
if (userid != null) {
    user = new UserDAO().getUser(userid);
}
// here user will be null if no userid has been stored on the session,
// and it wil be loaded from your persistence layer otherwise.