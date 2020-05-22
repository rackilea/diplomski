// Set route assessor to return response.
runner.http(builder -> builder
    .server(raServer)
    .send()
    .response(HttpStatus.OK)
    .messageType(MessageType.JSON)
    .contentType(ContentType.APPLICATION_JSON.getMimeType())
    .payload(new ClassPathResource("templates/assess-route-status.json")));