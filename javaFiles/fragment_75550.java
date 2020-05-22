@WebListener
public class LogoutListener implements HttpSessionListener {
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        // I don't know which user you are logging out here (you probably want to get some data from session)
        LogoutBean lgub = new LogoutBean();
        LogoutDao lgud = new LogoutDao();
        // don't need to check if session is null (it obviously isn't at this point, it's being destroyed)
        lgud.logoutUser(lgub);
    }

    // sessionCreated() goes here
}