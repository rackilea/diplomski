WebDriver driver = new HtmlUnitDriver() {
    protected WebClient modifyWebClient(WebClient client) {
        DefaultCredentialsProvider creds = new DefaultCredentialsProvider();

        creds.addCredentials(username, password, hostname, port, realm);

        client.setCredentialsProvider(creds);
        return client;
    }
};