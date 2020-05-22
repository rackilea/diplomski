OkHttpClient client = new OkHttpClient();

MediaType mediaType = MediaType.parse("application/json");
RequestBody body = RequestBody.create(mediaType, "{\n\t\"name\":\"hotel california\", \n\t\"createdAt\":1505727060471, \n\t\"steamUrl\":\"https://www.youtube.com/watch?v=lHje9w7Ev4U\"\n}");
Request request = new Request.Builder()
  .url("http://eventapi-dev.wynk.in/tv/events/v1/event")
  .post(body)
  .addHeader("content-type", "application/json")
  .addHeader("cache-control", "no-cache")
  .addHeader("postman-token", "08af0720-79cc-ff3d-2a7d-f208202e5ec0")
  .build();

Response response = client.newCall(request).execute();