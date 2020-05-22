Request request = chain.request();
Response response = chain.proceed(request);

ResponseBody responseBody = response.body();
String responseBodyString = response.body().string();
Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();

...

return newResponse;