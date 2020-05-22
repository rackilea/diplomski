HttpConnector
{
...
...
//    Properties added to enable NTLMv2 Auth

private String ntlmUser;
private String ntlmPassword;
private String ntlmDomain;
private String ntlmHost;
private String ntlmPort;
private boolean ntlmAuthentication;

//getters and setters

    protected HttpClient doClientConnect() throws Exception
{
    HttpState state = new HttpState();
    HttpClient client = new HttpClient();
    String localhost = InetAddress.getLocalHost().getHostName();
    //TODO setting domain as well.
    Credentials credentials;

    if (getProxyUsername() != null || getNtlmUser() != null)
    {
        if (isProxyNtlmAuthentication())
        {
            credentials = new NTCredentials(getProxyUsername(), getProxyPassword(), localhost, "");
            AuthScope authscope = new AuthScope(getProxyHostname(), getProxyPort());
            state.setProxyCredentials(authscope, credentials);
        }
        else if(isNtlmAuthentication()){
            AuthPolicy.registerAuthScheme(AuthPolicy.NTLM, CustomNTLM2Scheme.class);
            AuthScope authscope = new AuthScope(getNtlmHost(), Integer.valueOf(getNtlmPort()));
            credentials = new NTCredentials(getNtlmUser(), getNtlmPassword(), localhost, getNtlmDomain());
            state.setCredentials(authscope, credentials);
        }
        else
        {
            credentials = new UsernamePasswordCredentials(getProxyUsername(), getProxyPassword());
            AuthScope authscope = new AuthScope(getProxyHostname(), getProxyPort());
            state.setProxyCredentials(authscope, credentials);
        }

    }
    client.setState(state);
    client.setHttpConnectionManager(getClientConnectionManager());
    return client;
}