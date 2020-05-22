private void testOkHttpClient() {
    OkHttpClient httpClient = new OkHttpClient();
    try {
      Request request = new Request.Builder()
          .url("https://www.google.com")
          .build();
      Call call = httpClient.newCall(request);
      Response response = call.execute();
      System.out.println("First time " + response.body().string()); // I get the response
      System.out.println("Second time " + response.body().string()); // This will be empty
    } catch (IOException e) {
      e.printStackTrace();
    }
  }