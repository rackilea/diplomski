public class ApiClient extends Application {

    private static ApiClient apiClient = null; //singleton Object
    String apiURL = "http://your.url/";


    public static ApiClient getApiClient() {//getter for object
        if (apiClient == null)
            apiClient = new ApiClient();
        return apiClient;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

    public Retrofit getClient() {//Retrofit instance
        int myTime = 15;
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .connectTimeout(myTime, TimeUnit.SECONDS)
                .readTimeout(myTime, TimeUnit.SECONDS)
                .writeTimeout(myTime, TimeUnit.SECONDS)
                .addNetworkInterceptor(new StethoInterceptor());

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(apiURL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }
}