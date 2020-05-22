Retrofit retrofitAsync = new Retrofit.Builder()
            .baseUrl(BASE_URL_APPS)
            .client(createDefaultOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .build();