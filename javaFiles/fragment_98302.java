@Path("/logout")
@GET
@Produces(MediaType.APPLICATION_JSON)
public void logout(@Context HttpServletRequest request) {
    info.magnolia.context.Context ctx = MgnlContext.getInstance();
    if (ctx instanceof UserContext) {
        AuditLoggingUtil.log((UserContext) ctx);
        ((UserContext) ctx).logout();
    }

    if (request.getSession(false) != null) {
        request.getSession().invalidate();
    }
}