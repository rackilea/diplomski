private static Retrofit getAsIsRetrofit() {
    return new Retrofit.Builder()
            .client(mockOkHttpClient)
            .baseUrl("http://whatever")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}