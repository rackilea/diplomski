http()
    .client("restClient")
    .receive()
    .response(HttpStatus.OK)
    .messageType(MessageType.JSON)
    .payload("{\"version\":\"@variable('apiVersion')@\"}");