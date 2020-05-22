Client client = new Client();
    WebResource wresource = client.resource("http://localhost:8080/PdfMakerGF/rest/example/post");
    JSONObject json = new JSONObject();
    json.put("xml", DATA);
    json.put("plant", DATA);

        ClientResponse response =  
        wresource.type("application/json").post(ClientResponse.class, 
        json.toString());

        out = response.getEntity(String.class);
        System.out.println("RES = "+response);
        System.out.println("OUT = "+out);