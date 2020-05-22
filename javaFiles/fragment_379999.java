private static final String APP_ID = "clientId";
 private static final String APP_SECRET = "secret key";
 private static final String TENATID = "xxxxx";
 public static void main(String[] args) throws Exception {
 String authority = "https://login.microsoftonline.com/"+TENATID; 
 String resourceUrl = "https://graph.microsoft.com"; //Microsoft graph. AD graph: https://graph.windows.net
 ExecutorService service = Executors.newFixedThreadPool(1);
 AuthenticationContext context = new AuthenticationContext(authority, true, service);
        // Acquire Token
 Future<AuthenticationResult> result = context.acquireToken(
                resourceUrl,
                new ClientCredential(APP_ID, APP_SECRET),
                null
        );
        String token = result.get().getAccessToken();
        System.out.println(token);
    }