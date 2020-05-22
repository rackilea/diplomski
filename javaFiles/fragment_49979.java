@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadAsset(FormDataMultiPart multipart) {

    Map<String, List<FormDataBodyPart>> map = multipart.getFields();

    for (Map.Entry<String, List<FormDataBodyPart>> entry : map.entrySet()) {

        for (FormDataBodyPart part : entry.getValue()) {
            InputStream in = part.getEntityAs(InputStream.class);
            String name = part.getName();
            System.out.println("--- name: " + name);
        }
    }
    return Response.ok("cool upload").build();
}