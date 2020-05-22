OkHttpClient client = new OkHttpClient();

RequestBody requestBody = new MultipartBody.Builder()
    .setType(MultipartBody.FORM)
    .addFormDataPart("image", "your file name.png",
        RequestBody.create(MEDIA_TYPE_PNG, new File("your absolute file path")))
    .build();

Request request = new Request.Builder()
    .url("Your url")
    .post(requestBody)
    .build();

//Check the response
try (Response response = client.newCall(request).execute()) {
  if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

  System.out.println(response.body().string());
}