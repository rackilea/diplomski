public List<Country> findAll() throws ClientErrorException {
    WebTarget resource = webTarget;
    resource = resource.path("countries");
    Response response =  resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    if (response.getStatus() != 200) {
        System.out.println(response.getHeaderString("errorResponse"));
        return null;
    } else {
        return response.readEntity(new GenericType<List<Country>>(){});
    }
}