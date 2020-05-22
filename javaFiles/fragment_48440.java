protected Object formBackingObject(HttpServletRequest request) throws Exception {
    User user = null;
    if (request.getAttribute("usuario") != null)
        user = (User) request.getAttribute("usuario");
    else
         user = new CreateUser();      
    return user;
}