// this can be in some util class, let's call it SessionUtil
static final String SESSION_REGISTER = "session.register";
public static synchronized void registerSession(ServletRequest req, HttpSession ses, String userName) {
  ServletContext ctx = req.getServletContext();
  Map<String, List<HttpSession>> register = (Map<String, List<HttpSession>>) ctx.getAttribute(SESSION_REGISTER);
  if (register == null) {
    register = new HashMap<>();
    ctx.setAttribute(SESSION_REGISTER, register);
  }
  List<HttpSession> sessions = register.computeIfAbsent(userName, k -> new ArrayList<>());
  sessions.add(ses);
}