@Path("/poll")
@GET
public void poll(@Suspended final AsyncResponse asyncResponse)
        throws InterruptedException {
    asyncResponse.setTimeout(30, TimeUnit.SECONDS);
    this.asyncResponse = asyncResponse;
}

@POST
@Path("/printed")
public Response printCallback(String barcode) throws IOException {
    // ...

    this.asyncResponse.resume("MESSAGE");

    return Response.ok().build();
}