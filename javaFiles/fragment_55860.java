public String requestResource(String baseURL, String path) {
        Client wsClient = Client.create();
        WebResource rs = wsClient.resource(baseURL);
        String response = rs.path(path).type(MediaType.APPLICATION_JSON).post(String.class, item);
        return response;

    }