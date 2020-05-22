http()
    .client("restClient")
    .receive()
    .response(HttpStatus.OK)
    .messageType(MessageType.JSON)
    .extractFromPayload("$.version", "apiVersion")
    .payload("{\"version\":\"@ignore@\"}");