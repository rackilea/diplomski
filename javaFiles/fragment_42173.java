public static void login(String db) {
        Client.setServer(Client.Server.LOCAL);
        AuthenticationProvider provider = new AuthenticationProvider();
        provider.setCredentialsProvider(new SimpleCredentialsProvider("user", "pass", dbString, "secretkey"));
        Client.setAuthenticationProvider(provider);
        Client.login();
}