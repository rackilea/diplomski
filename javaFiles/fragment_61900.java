@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces({ MediaType.APPLICATION_JSON })
public ServiceResponse uploadFIle(FormDataMultiPart form) {
    byte[] fileContents = form.getField("iconBmp").getValueAs(byte[].class);
    String uploadedfilename = form.getField("iconBmp").getContentDisposition().getFileName();
    String description = form.getField("description").getValue();
    String fileName = form.getField("fileName").getValue();
    //String id = form.getField("id").getValue();

    // TODO:
    //catIconBean.uploadIcon(fileContents);

    ServiceResponse sr = new ServiceResponse();
    sr.httpResponse = true;
    return sr;
}