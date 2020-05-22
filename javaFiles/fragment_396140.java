OkHttpClient client = new OkHttpClient();
client.setConnectTimeout(15, TimeUnit.SECONDS); // connect timeout
client.setReadTimeout(15, TimeUnit.SECONDS);    // socket timeout

Request request = new Request.Builder().url(url).build();
Response response = client.newCall(request).execute();