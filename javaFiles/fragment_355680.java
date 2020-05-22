File file = new File("/Users/mr_abc/mytarfile.tar");
MultipartFormDataOutput upload = new MultipartFormDataOutput();
        upload.addFormData("file", targetStream, MediaType.MULTIPART_FORM_DATA_TYPE, "mytarfile.tar");

request = new ClientRequest("http://mydomain/upload");

request.queryParameter("sender", "mr_abc");
request.body(MediaType.MULTIPART_FORM_DATA_TYPE, upload);
ClientResponse<String> response = request.post(String.class);