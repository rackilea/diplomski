http(httpActionBuilder -> httpActionBuilder
                .client(sutClient)
                .receive()
                .response()
                .messageType(MessageType.JSON)
                .name("operationResponse")
                .extractFromHeader(HttpMessageHeaders.HTTP_STATUS_CODE, "statusCode"));