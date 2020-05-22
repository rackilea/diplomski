private NYTimesService() {

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Result.class, new ResultsDeserializerJson()).create();

    mAsyncRestAdapter = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setConverter(new GsonConverter(gson))
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addEncodedQueryParam("api-key", API_KEY);
                }
            })
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();
}