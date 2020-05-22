@Override
  public void init() throws ServletException {
    super.init();
    // do not overwrite if value is supplied in constructor
    if (sessionCookieName == null) {
      // servlet configuration precedes context configuration
      sessionCookieName = getServletConfig().getInitParameter(
          XsrfTokenServiceServlet.COOKIE_NAME_PARAM);
      if (sessionCookieName == null) {
        sessionCookieName = getServletContext().getInitParameter(
            XsrfTokenServiceServlet.COOKIE_NAME_PARAM);
      }
      if (sessionCookieName == null) {
        throw new IllegalStateException(
            XsrfTokenServiceServlet.COOKIE_NAME_NOT_SET_ERROR_MSG);
      }
    }
  }