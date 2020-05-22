private OkHttpClient createDefaultOkHttpClient() {
  HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
  interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
  return new OkHttpClient().newBuilder()
          .addInterceptor(interceptor)
          .build();
}