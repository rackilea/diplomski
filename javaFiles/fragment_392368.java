String URL_LOGIN = "http://localhost:9080/foo/j_security_check";
String URL_DATA = "http://localhost:9080/foo/auth.html";
Client client = Client.create();

// add a filter to set cookies received from the server and to check if login has been triggered
client.addFilter(new ClientFilter() {
    private ArrayList<Object> cookies;

    @Override
    public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
        if (cookies != null) {
            request.getHeaders().put("Cookie", cookies);
        }
        ClientResponse response = getNext().handle(request);
        // copy cookies
        if (response.getCookies() != null) {
            if (cookies == null) {
                cookies = new ArrayList<Object>();
            }
            // A simple addAll just for illustration (should probably check for duplicates and expired cookies)
            cookies.addAll(response.getCookies());
        }
        return response;
    }
});

String username = "me";
String password = "me";

// Login:
WebResource webResource = client.resource(URL_LOGIN);

com.sun.jersey.api.representation.Form form = new Form();
form.putSingle("j_username", username);
form.putSingle("j_password", password);
webResource.type("application/x-www-form-urlencoded").post(form);

// Get the protected web page:
webResource = client.resource(URL_DATA);
String response = webResource.get(String.class);