OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();

final Request.Builder builder = new Request.Builder();

HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
urlBuilder.addEncodedQueryParameter("lat", lat)
urlBuilder.addEncodedQueryParameter("lng", lng)

builder.url(urlBuilder.build().toString());

client.newCall(builder.build())