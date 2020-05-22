OkHttpClient okHttpClient = new OkHttpClient.Builder()  
    .connectTimeout(1, TimeUnit.MINUTES)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(15, TimeUnit.SECONDS)
    .build();

Retrofit.Builder builder = new Retrofit.Builder()  
    .baseUrl("http://10.0.2.2:3000/")
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create());