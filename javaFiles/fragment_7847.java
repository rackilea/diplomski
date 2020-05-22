public static void main(String[] args) {

            try {

                Client client = Client.create();

                WebResource webResource = client
                   .resource("http://localhost:8080/RESTfulExample/rest/foo");

                String input = "{
    \"customer\": {
        \"name\": \"Smith\",
        \"documents\": [{
                \"id\": \"100\",
                \"content\": \"lorem\"
            },
            {
                \"id\": \"101\",
                \"content\": \"ipsum\"
            }
        ]
    }
}";

                ClientResponse response = webResource.type("application/json")
                   .post(ClientResponse.class, input);

                if (response.getStatus() != 201) {
                    throw new RuntimeException("Failed : HTTP error code : "
                         + response.getStatus());
                }

                System.out.println("Output from Server .... \n");
                String output = response.getEntity(String.class);
                System.out.println(output);

              } catch (Exception e) {

                e.printStackTrace();

              }

            }