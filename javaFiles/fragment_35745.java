RequestBody formBody = new FormBody.Builder()
            .add("name", "name")
            .add("emailAdress", "xxx@xxx.com")
            .build();

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url(url)
            .post(formBody)
            .build();

    Response response = client.newCall(request).execute();
    return response.body().string();