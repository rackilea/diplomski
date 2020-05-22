OkHttpClient client = new OkHttpClient();

client.interceptors().add(new Interceptor() {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder().addQueryParameter("name","value").build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
});

Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("...")
        .client(client)
        .build();