public class LoginRestClient
{
    private static final String BASE_URL = "";
    private LoginApiService apiService;

    public LoginRestClient()
    {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ApiIntentService.getHostAddress())
                .setConverter(new GsonConverter(gson))
                .setClient(ApiIntentService.createClient(60, TimeUnit.SECONDS, 20, TimeUnit.SECONDS))
                .build();

        apiService = restAdapter.create(LoginApiService.class);
    }

    public LoginApiService getApiService() {
        return apiService;
    }
}