/**
 * 
 * @return returns WebServiceClass
 */
@WebEndpoint(name = "WebServiceClassSoap")
public WebServiceClassSoap getWebServiceClassSoap() {
    return dynamicAuthorisation(super.getPort(WebServiceClassSoap,
            WebServiceClassSoap.class));
} 

private WebServiceClassSoap  dynamicAuthorisation (WebServiceClassSoap  service) {
    return dynamicAuthorisation(service, 
                PhaseInterceptorChain.getCurrentMessage().get("request_usr").toString(),
                PhaseInterceptorChain.getCurrentMessage().get("request_pwd").toString());
}


private WebServiceClassSoap  dynamicAuthorisation (WebServiceClassSoap  service, String username, String password) {

    Client client = ClientProxy.getClient(service);
    HTTPConduit http = (HTTPConduit) client.getConduit();

    AuthorizationPolicy auth = http.getAuthorization();

    auth.setUserName(username);
    auth.setPassword(password);

    http.setAuthorization(auth);

    return service;
}