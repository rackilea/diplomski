public class RestClient implements IRestClient {
    private static final String TAG = RestClient.class.getSimpleName();
    private IRestAPI client;
    private String username;
    private String password;
    private RequestAccessToken requestAccessToken;
    private Access access;

    private static RestClient singleton;

    // TODO: use Dagger
    public static RestClient getInstance()
    {
        if(singleton == null)
        {
            singleton = new RestClient();
        }
        return singleton;
    }

    /**
     * Access declared as private to prevent instantiation outside of this class.
     */
    private RestClient()
    {
        requestAccessToken = new RequestAccessToken();
    }

    /**
     * Request an access token.
     *
     * @return A string containing the access token
     */
    public String requestAccessToken(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.access = requestAccessToken.requestAccessToken(username, password);
        return this.access.getAccess_token();
    }

    /**
     * Wrapper for {@link #requestAccessToken(String, String) requestAccessToken}
     * @return
     */
    public String requestAccessToken()
    {
        if(username == null || password == null) {
            throw new IllegalArgumentException("missing user/pass");
        }
        return requestAccessToken(username, password);
    }

    /**
     * Eventually we want to look at Access.getExpires_in() and return weather or not the token is
     * expired.
     *
     * @return value indicating weather or not the token is expired.
     */
    public boolean isAccessTokenExpired()
    {
        return false;
    }

    /**
     * Return an instance of a rest client with a valid access token.
     * @return
     */
    private IRestAPI getClient()
    {
        if(access == null)
        {
            requestAccessToken();
        }
        if(isAccessTokenExpired())
        {
            // Refresh token
        }
        if(client == null) {
            RequestInterceptor requestInterceptor = new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Authorization", "Bearer " + access.getAccess_token());
                }
            };

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Config.ENDPOINT)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setRequestInterceptor(requestInterceptor)
                    .build();
            client = restAdapter.create(IRestAPI.class);
        }
        return client;
    }

    /**
     * Login to the api and get a access token.
     *
     * @param username
     * @param password
     */
    @Override
    public void login(String username, String password)
    {
        Log.d(TAG, "login");
        requestAccessToken(username, password);
    }

    /**
     * Request a list of organizations.
     * @return List of Organizations.
     */
    @Override
    public List<Organization> requestOrganizations() {
        Log.d(TAG, "requestOrganizations");
        // TODO: error handling
        // TODO: caching... which isn't http
        return getClient().requestOrganizations();
    }

    // Add more api requests here

}