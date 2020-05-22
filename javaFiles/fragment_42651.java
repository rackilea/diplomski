protected void setMySessionCookie(HttpServletResponse response, String jSessionId) {

    logger.log(Level.INFO, "setting MYSESSIONID = " + jSessionId);

    final String cookieName = "MYSESSIONID";
    // you could assign it some encoded value
    final String cookieValue = jSessionId; 
    // TODO enforce SSL
    final Boolean useSecureCookie = false; 
    final int expiryTime = -1; // 24h in seconds
    final String cookiePath = "/";

    Cookie cookie = new Cookie(cookieName, cookieValue);
    // determines whether the cookie should only be sent using a secure protocol, such as HTTPS or SSL
    cookie.setSecure(useSecureCookie);
    // A negative value means that the cookie is not stored persistently and will be deleted when the Web browser exits. A zero value causes the cookie to be deleted.
    cookie.setMaxAge(expiryTime);
    // The cookie is visible to all the pages in the directory you specify, and all the pages in that directory's subdirectories
    cookie.setPath(cookiePath);

    response.addCookie(cookie);
}