public boolean isLoggedIn() {
    Session session = Session.getActiveSession();
    if (session != null && session.isOpened()) {
        return true;
    } else {
        return false;
    }
}