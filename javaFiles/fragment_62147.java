@Provides
@Singleton
public Retrofit provideRetrofit(@Named("cached") OkHttpClient okHttpClient)
{
    return new Retrofit.Builder()
            .baseUrl("...")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();
}