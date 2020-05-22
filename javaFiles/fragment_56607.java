public Response uploadFile(@FormDataParam("file") InputStream file,
                           @FormDataParam("file") FormDataContentDisposition fdcd) {
    String filename = fcdc.getFileName();

    // You don't need to create the FormDataMultiPart
    // just save the InputStream parameter
}