Retrofit restAdapter = new Retrofit.Builder()
    .baseUrl(...)
    .client(...)
    .addConverterFactory(...)
    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
    .build();