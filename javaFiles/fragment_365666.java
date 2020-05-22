public class ForbiddenException extends WebApplicationException {

    public ForbiddenException(String code, String readableMessage) {
        super(Response.status(Status.FORBIDDEN).entity(new ForbiddenEntity(code, readableMessage)).build());
    }

}