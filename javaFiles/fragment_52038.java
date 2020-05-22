private void sendSessionExpiredResponse(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse) 
        throws IOException, ServletException {
    httpServletRequest.getSession(true); // force valid session to exist
    httpServletRequest.setAttribute("isExpired", true);
    RequestDispatcher rd = filterConfig.getServletContext()
        .getNamedDispatcher("SessionExpired");
    rd.forward(httpServletRequest, httpServletResponse);
}