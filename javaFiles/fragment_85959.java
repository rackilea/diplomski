ServiceClientCredentials credentials = new KeyVaultCredentials() {

    @Override
    public String doAuthenticate(String authorization, String resource, String scope) {
        AuthenticationResult res = null;

        try {
            res = GetAccessToken(authorization, resource, clientId, secret);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            return res.getAccessToken();
    }

    private AuthenticationResult GetAccessToken(String authorization, String resource, String clientID, String clientKey)
            throws InterruptedException, ExecutionException {
        AuthenticationContext ctx = null;
        ExecutorService service = Executors.newFixedThreadPool(1);
        try {
            ctx = new AuthenticationContext(authorization, false, service);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Future<AuthenticationResult> resp = ctx.acquireToken(resource, new ClientCredential(
            clientID, clientKey), null);
            AuthenticationResult res = resp.get();
            return res;
        }

    };
KeyVaultClient client = new KeyVaultClient(credentials);
String keyIdentifier = "https://<your-keyvault>.vault.azure.net/keys/<your-key>/xxxxxxxxxxxxxxxxxxxxxx";
KeyBundle keyBundle = client.getKey(keyIdentifier);