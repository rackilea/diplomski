AppObject<DimRequirement> appObject = new AppObject<DimRequirement>();
        appObject.setClientKey(4L);
        Client client = Client.create();
        WebResource webResource = client
                   .resource("http://localhost:8080/myproject/");

        JSONObject json = new JSONObject(appObject);
        ClientResponse response = webResource.path("rest").path("requirement/getreq").type("application/json").accept("application/json")
                .post(ClientResponse.class,json.toString());
        String output = response.getEntity(String.class);
       AppObject<DimRequirement> appObjectclientns = new ObjectMapper()
                .readValue(output,
                        new TypeReference<AppObject<DimRequirement>>() {
                        });