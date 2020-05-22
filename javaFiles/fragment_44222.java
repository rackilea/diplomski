@GET
public Response getSomething() {
    ...
    Response.ResponseBuilder builder = Response.status(200);
    Response response = builder.entity(file)
                               .header("Content-Type", "someType")
                               .build();
    return response;
}