final HttpPost httppost = new HttpPost("https://host/upload");
httppost.addHeader("Authorization", "Bearer xxx");
httppost.addHeader("Accept", "application/json");
httppost.addHeader("Content-Type", "multipart/form-data");

final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
final File file = new File("c:\\tmp\\myfile.pdf");
builder.addPart("file", new FileBody(file));
builder.addTextBody("type", "file");
final HttpEntity entity = builder.build();
httppost.setEntity(entity);
final HttpResponse response = httpclient.execute(httppost);
httpclient.close();