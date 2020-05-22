@WebListener /* or reister it in web.xml */
public final class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(final HttpSessionEvent se) { }

    @Override
    public void sessionDestroyed(final HttpSessionEvent se) {

        // obtain HTTP session
        HttpSession session = se.getSession();

        /* as you cannot retrieve the user ID from the
         * HTTP session, getRemoteUser() is not available, you must
         * read the user ID from a custom parameter
         */
        String user = (String) session.getAttribute("myCustomAttribute");

        // work with it

    }

}