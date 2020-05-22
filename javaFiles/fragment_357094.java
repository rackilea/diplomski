public class NewServlet extends HttpServlet {

    public String apiBaseUrl = "api.fitbit.com";
    public String webBaseUrl = "https://www.fitbit.com";
    public String consumerKey = "your key";
    public String consumerSecret = "your secret";
    public String callbackUrl = "*****/run?Controller=Verifier";
    public FitbitAPIClientService<FitbitApiClientAgent> apiClientService = null;
    public String oauth_token = null;
    public String oauth_verifier = null;
    public String token = null;
    public String tokenSecret = null;
    public String userId = null;
    public APIResourceCredentials resourceCredentials=null;
    public FitbitApiClientAgent agent =null;
    public LocalUserDetail user=null;
    public Gson gson =null;
    public UserInfo userInfo=null;



    private static Properties getParameters(String url) {
        Properties params = new Properties();
        String query_string = url.substring(url.indexOf('?') + 1);
        String[] pairs = query_string.split("&");
        for (String pair : pairs) {
            String[] kv = pair.split("=");
            params.setProperty(kv[0], kv[1]);
        }
        return params;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParserConfigurationException, SAXException, Exception {
        PrintWriter out = response.getWriter();
response.addHeader("Access-Control-Allow-Origin", "*");

        //   out.println(" ----- process Request Called-----");
        String controllerValue = request.getParameter("Controller");
      // out.println(" Controller Request :  "+param);

        if (controllerValue == null) {
            //  out.println(" inside if part ");
            FitbitAPIEntityCache entityCache = new FitbitApiEntityCacheMapImpl();
            FitbitApiCredentialsCache credentialsCache = new FitbitApiCredentialsCacheMapImpl();
            FitbitApiSubscriptionStorage subscriptionStore = new FitbitApiSubscriptionStorageInMemoryImpl();
            FitbitApiClientAgent apiClientAgent = new FitbitApiClientAgent(apiBaseUrl, webBaseUrl, credentialsCache);
            out.println("testing2");

            apiClientService
                    = new FitbitAPIClientService<FitbitApiClientAgent>(
                            apiClientAgent,
                            consumerKey,
                            consumerSecret,
                            credentialsCache,
                            entityCache,
                            subscriptionStore
                    );
            // out.println("<script>localStorage.setItem('api',apiClientService);</script>");   
            LocalUserDetail userDetail = new LocalUserDetail("-");

            try {
                //    out.println("testing4");
                String authorizationURL = apiClientService.getResourceOwnerAuthorizationURL(userDetail, callbackUrl);
                out.println("access by web browser: " + authorizationURL);
                out.println("Your web browser shows redirected URL.");
                out.println("Input the redirected URL and push Enter key.");
                response.sendRedirect(authorizationURL);
            } catch (FitbitAPIException ex) {
                out.println("exception : " + ex);
                //Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (controllerValue.equalsIgnoreCase("Verifier")) {

            oauth_token = request.getParameter("oauth_token");
            oauth_verifier = request.getParameter("oauth_verifier");
            resourceCredentials = apiClientService.getResourceCredentialsByTempToken(oauth_token);

            if (resourceCredentials == null) {
                out.println(" resourceCredentials = null ");
                throw new Exception("Unrecognized temporary token when attempting to complete authorization: " + oauth_token);
            }
            if (!resourceCredentials.isAuthorized()) {
                resourceCredentials.setTempTokenVerifier(oauth_verifier);
                apiClientService.getTokenCredentials(new LocalUserDetail(resourceCredentials.getLocalUserId()));
            }
            userId = resourceCredentials.getLocalUserId();
            token = resourceCredentials.getAccessToken();
            tokenSecret = resourceCredentials.getAccessTokenSecret();
            user = new LocalUserDetail(userId);
            userInfo = apiClientService.getClient().getUserInfo(new LocalUserDetail(resourceCredentials.getLocalUserId()));
            user = new LocalUserDetail(userId);
            agent = apiClientService.getClient(); 

            response.sendRedirect("http://localhost:8084/FitbitClientCheck/");

}