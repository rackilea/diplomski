MultipartFormDataOutput output = new MultipartFormDataOutput();
                      // file (below) doesn't have to be a `byte[]`
                      // It can be a `File` object and work just the same
output.addFormData("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE);

Response response = target.request()
        .post(Entity.entity(output, MediaType.MULTIPART_FORM_DATA));