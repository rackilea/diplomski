private WebClient webClient;

public RESTfulClient(String url, String username, String password)
        throws IllegalArgumentException
{
    this.username = username;
    this.password = password;
    this.serviceURL = url;

    if (username == null || password == null || serviceURL == null)
    {
        String msg = "username, password and serviceURL MUST be defined.";
        log.error(msg);
        throw new IllegalArgumentException(msg);
    }

    webClient = WebClient.create(this.serviceURL,
            this.username,
            this.password,
            null); // Spring config file - we don't use this
}