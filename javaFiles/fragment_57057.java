@Override
public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
        throws IOException, ServletException {
    DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
    if(defaultSavedRequest != null){
       String targetURL = defaultSavedRequest.getRedirectUrl();
       redirectStrategy.sendRedirect(request, response, targetURL);
       return;
    }
}