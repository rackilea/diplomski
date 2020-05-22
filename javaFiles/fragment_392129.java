ClientConfig config = new DefaultClientConfig();
Client client = Client.create(config);

public void getUser() {         
    WebResource service = client.resource(RESOURCE_URL);

    // Get response as String
    String response = service
        .path("/addUser")
        .accept(MediaType.TEXT_PLAIN)
        .get(String.class);

        return response;
}