HttpEntity entity = MultipartEntityBuilder
    .create()
    .addTextBody("number", "5555555555")
    .addTextBody("clip", "rickroll")
    .addBinaryBody("upload_file", new File(filePath), ContentType.create("application/octet-stream"), "filename")
    .addTextBody("tos", "agree")
    .build();

HttpPost httpPost = new HttpPost("http://some-web-site");
httpPost.setEntity(entity);
HttpResponse response = httpClient.execute(httpPost);
HttpEntity result = response.getEntity();