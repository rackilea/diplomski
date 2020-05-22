String gateway_url = "https://<GatewayHost>.azurewebsites.net/";
    String app_id_uri = gateway_url + "login/aad";
    String authority = "https://login.microsoftonline.com/<aad-domain>.onmicrosoft.com";
    String clientId = "<clientId>";
    String clientSecret = "<key>";
    String url = "https://<ApiAppHost>.azurewebsites.net/...";
/*
 *  Get Access Token from Gateway Login URL with authentication provider name
 *  Note: Please refer to the aad sample in Java for Native Headless at https://github.com/Azure-Samples/active-directory-java-native-headless
 */
HttpsURLConnection conn = (HttpsURLConnection) new URL(app_id_uri).openConnection();
AuthenticationContext context = null;
    AuthenticationResult result = null;
    ExecutorService service = null;
    try {
        service = Executors.newFixedThreadPool(1);
        context = new AuthenticationContext(authority, false, service);
        ClientCredential credential = new ClientCredential(clientId, clientSecret);
        Future<AuthenticationResult> future = context.acquireToken(app_id_uri, credential, null);
        result = future.get();
    } finally {
        service.shutdown();
    }
    String accessToken = null;
    if (result == null) {
        throw new ServiceUnavailableException(
                "authentication result was null");
    } else {
        accessToken = result.getAccessToken();
        System.out.println("Access Token: " +accessToken);
    }
    /*
     * Using access token to get authentication token
     */
    String data = "{\"access_token\": \""+accessToken+"\"}";
    conn.setRequestMethod("POST");
    conn.setDoOutput(true);
    conn.addRequestProperty("Content-Length", data.length()+"");
    new DataOutputStream(conn.getOutputStream()).writeBytes(data);
    String authTokenResp = IOUtils.toString(conn.getInputStream());
    System.out.println("Get Authentication Token Response: " + authTokenResp);
    /*
     * The content of Authentication Token Response is as {"user": {"userId": "sid:xxx...xxx"}, "authenticationToken": "xxxx...xxxxx"}.
     * Need to extract the authenticationToken from Json.
     */
    Gson gson = new Gson();
    Map<String, Object> map = gson.fromJson(authTokenResp, Map.class);
    String authenticationToken = (String) map.get("authenticationToken");
    System.out.println("Authentication Token: "+authenticationToken);
    /*
     * Using authentication token as X-ZUMO-AUTH header to get data from Api App
     * Note: Must using Apache Common HttpClient supported HTTP 30x redirection, Class Http(s)URLConnection not support.
     *          There are three times continuous 302 redirection in accessing Api App with zumo token. 
     */
    HttpGet httpGet = new HttpGet(url);
    httpGet.addHeader("x-zumo-auth", authenticationToken);
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpResponse resp = httpclient.execute(httpGet);
    String apiAppData = IOUtils.toString(resp.getEntity().getContent());
    System.out.println(apiAppData);