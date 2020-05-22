@Override
public Response toResponse(Throwable error) {
    Response response;
    if (error instanceof WebApplicationException) {
        WebApplicationException webEx = (WebApplicationException)error;
        response = webEx.getResponse();
    } else {
        response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Internal error").type("text/plain").build();
    }
    return response;
}