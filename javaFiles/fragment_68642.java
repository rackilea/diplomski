@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response post(
        @FormDataParam("part") String s,
        @FormDataParam("part") FormDataContentDisposition d) {

    final Map<String, String> parameters = Maps.newHashMap();
    parameters.put("boundary", "myboundary");

    final MediaType mediaType = new MediaType("multipart", "form-data", parameters);

    return Response
            .ok(s + ":" + d.getFileName(), mediaType)
            .build();
}