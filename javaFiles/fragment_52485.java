public AuthStatus validateRequest(MessageInfo messageInfo,
        Subject clientSubject,
        Subject serviceSubject) throws AuthException {

    // clientSubject.getPrincipals() returns the principals
    // check this set to know if the user is not logged in

    // if the user is not logged in do the following
    HttpServletResponse response = (HttpServletResponse) messageInfo.getResponseMessage();
    response.sendRedirect("login.html");
}