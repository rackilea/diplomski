@Context
private HttpServletRequest request;

...

User user;
if((user = validateUser(uid)) == null) {
    requestContext.abortWith(
            Response.status(Response.Status.UNAUTHORIZED).build());
}

request.getSession().setAttribute("user", user);