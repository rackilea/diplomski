private HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
private static final String LOGGED_IN_USER = "loggedInUser";

public User getLoggedInUser() {
    return (User) session.getAttribute(LOGGED_IN_USER);
}

public void setLoggedInUser(User user) {
    session.setAttribute(LOGGED_IN_USER, user);
}`