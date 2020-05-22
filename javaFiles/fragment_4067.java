@GET
public Response getChunkedResponse() throws IOException {
    // Check access here
    if (!authorized()) {
        Response.status(403).entity("No Access").build();
    } else {
        final ChunkedOutput<String> output = new ChunkedOutput<String>(String.class);

        new Thread() {
            public void run() {
                // Your operation which returns chunked output.
            }
        }.start();
        return Response.ok(output).build();
    }
}