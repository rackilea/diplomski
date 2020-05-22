public class NetworkClient {
private static final String BASE_URL = "http://localhost:8080";
private static Retrofit retrofit;
public static Retrofit getRetrofitClient(Context context) {
    if (retrofit == null) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    return retrofit;
}