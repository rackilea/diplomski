HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new 
    OkHttpClient.Builder().addInterceptor(interceptor).build();

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Quotes.class, new QuotesDeserializer())
            .create();

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson));

    Retrofit retrofit = builder.build();

    coinMarketClient = retrofit.create(CoinMarketClient.class);