//file is your opened file and url is the server url
OkHttpClient client = new OkHttpClient.Builder().build();
RequestBody formBody = new MultipartBody.Builder()
    .setType(MultipartBody.FORM)
    .addFormDataPart("file", file.getName(),
        RequestBody.create(MediaType.parse("text/plain"), file))
    .build();
Request request = new Request.Builder().url(url).post(formBody).build();
Response response = client.newCall(request).execute();