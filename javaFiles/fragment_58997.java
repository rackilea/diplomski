class RequestProducer {
    private ObjectMapper objectMapper;

    public RequestProducer(ObjectMapper objectMapper) {
       this.objectMapper = objectMapper;
    }

    HttpRequest post(SomePojo somePojo) {
        return HttpRequest.POST("/user")
            .withEntity(HttpEntities.create(
              ContentTypes.APPLICATION_JSON,
              objMapper.writeValueAsString(somePojo)));        
    }
}