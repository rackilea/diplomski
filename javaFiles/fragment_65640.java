public static final String BASE_URL = "http://api.myservice.com";

public RestAdapter providesRestAdapter(Gson gson) {
    return new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .build();
}