@GET
@Path("/login/{userName}")
public String login(@PathParam("userName") String userName, @Context HttpServletRequest servletRequest) {
    HttpSession session = request.getSession();
    session.setAttribute("userName", userName);
}