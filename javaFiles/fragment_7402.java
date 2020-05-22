public final User getUser() {

    RequestAttributes requestAttributes = RequestContextHolder
            .currentRequestAttributes();
    ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
    HttpServletRequest request = attributes.getRequest();
    HttpSession httpSession = request.getSession(true);

    Object userObject = httpSession.getAttribute("WEB_USER");
    if (userObject == null) {
        return null;
    }

    User user = (User) userObject;
    return user;
}