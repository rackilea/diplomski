public static void main(String[] args) {

    try {
        Client client = Client.create();

        WebResource webResource = client.resource(baseuri);

        String input = "{\"switch\": \"00:00:00:00:00:00:00:01\", "
                + "\"name\":\"flow-mod-1\", \"priority\":\"32768\", "
                + "\"ingress-port\":\"1\",\"active\":\"true\", "
                + "\"actions\":\"output=2\"}";

        // POST method
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").post(ClientResponse.class, input);

        // check response status code
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        // display response
        String output = response.getEntity(String.class);
        System.out.println("Output from Server .... ");
        System.out.println(output + "\n");
    } catch (Exception e) {
        e.printStackTrace();
    }

}