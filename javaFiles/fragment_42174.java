private String dbString;

public CustomRestClient(String db) {
    this.dbString = db;
    try {
        Client.setServer(Client.Server.LOCAL);
        AuthenticationProvider provider = new AuthenticationProvider();
        provider.setCredentialsProvider(new SimpleCredentialsProvider("user", "pass", dbString, "secretkey"));
        Client.setAuthenticationProvider(provider);
        Client.login();
    } catch (ClientException e) {
        e.printStackTrace();
    }