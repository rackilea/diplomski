public void login() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    try {
        Principal userPrincipal = request.getUserPrincipal();
        if (request.getUserPrincipal() != null) {
            request.logout();
        }
        request.login(username, password);
        userPrincipal = request.getUserPrincipal();
        authUser = userDao.findByLogin(userPrincipal.getName());
    }
    catch (ServletException ex) {
        java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
    }