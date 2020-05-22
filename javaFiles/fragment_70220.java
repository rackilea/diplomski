HttpEntity entity = MultipartEntityBuilder
 .create()
 .addTextBody("field1","val1")
 .addTextBody("field2","val2")
 .addBinaryBody("file", new File("somefile.zip"),ContentType.create("application/zip"),"somefile.zip")
 .build();
HttpPost post = new HttpPost("https://www.some.domain");
post.setEntity(entity);