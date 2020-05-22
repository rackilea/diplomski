final ConfigTree tree = new ConfigTree("WrappedMessage");
    tree.setAttribute("endpointUrl", "http://127.0.0.1:8080/esb-echo");
    tree.setAttribute("method", "post");
    tree.setAttribute("unwrap", "false");
    tree.setAttribute("MappedHeaderList", "SOAPAction, Content-Type, Accept, If-Modified-Since");

    HttpRouter router = new HttpRouter(tree);
    Message message = MessageFactory.getInstance().getMessage(type);
    message.getBody().add("bar");

    Message response = router.process(message);
    String responseBody = (String)response.getBody().get();
    String responseStr = null;
    if (deserialize)
        responseStr = Encoding.decodeToObject(responseBody).toString();
    else
        responseStr = responseBody;

    return responseStr;