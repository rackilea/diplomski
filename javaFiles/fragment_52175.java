@Context
UriInfo uriInfo;

@Override
public Response toResponse(NotFoundException e) {
    String html
        = "<p style='font-size:20px;font-family:Sans-serif'>"
        + "Service is unavailable message."
        + "</p>"
        + "<a href='http://www.stackoverflow.com'>"
        + "Check out Stackoverflow</a>";
    html += "<p>Requested URI: " + uriInfo.getAbsolutePath() + "</p>";
    return Response.status(Status.NOT_FOUND)
            .entity(html).build();
}