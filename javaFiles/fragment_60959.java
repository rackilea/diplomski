@Path("test")
public static class TestResource {
    @GET
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public Response get() throws Exception {
        final MultiPart multiPart = new FormDataMultiPart()
                .field("json-data", new Model("Test Value"), MediaType.APPLICATION_JSON_TYPE)
                .bodyPart(new FileDataBodyPart("file-data", new File("test.txt")));
        return Response.ok(multiPart).build();
    }
}