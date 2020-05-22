public void login(HttpServletRequest req, String user, String pass) { 
    UsernamePasswordAuthenticationToken authReqz = new UsernamePasswordAuthenticationToken(user, pass);
    Authentication auth = authManager.authenticate(authReq);

    SecurityContext sc = SecurityContextHolder.getContext();
    sc.setAuthentication(auth);
    HttpSession session = req.getSession(true);
    session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
}