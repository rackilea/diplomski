/**
 * log out the current user using Spring security and Vaadin session management
 */
void requestLogout() {
    //https://stackoverflow.com/a/5727444/1572286
    SecurityContextHolder.clearContext();
    req.getSession(false).invalidate();

    // And this is similar to how logout is handled in Vaadin 8:
    // https://vaadin.com/docs/v8/framework/articles/HandlingLogout.html
    UI.getCurrent().getSession().close();
    UI.getCurrent().getPage().reload();// to redirect user to the login page
}