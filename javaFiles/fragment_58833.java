public static synchronized void invalidateSessions(ServletRequest req, HttpSession current, String userName) {
  ServletContext ctx = req.getServletContext();
  Map<String, List<HttpSession>> register = (Map<String, List<HttpSession>>) ctx.getAttribute(SESSION_REGISTER);
  if (register != null) {
    List<HttpSession> sessions = register.get(userName);
    if (sessions != null) {
      for (HttpSession ses : sessions) {
        if (!ses.equals(current)) {
          ses.invalidate();
        }
      }
    }
  }
}