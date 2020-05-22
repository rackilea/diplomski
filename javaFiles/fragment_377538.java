restConfiguration().component("jetty").host("0.0.0.0").port(24999).bindingMode(RestBindingMode.json).dataFormatProperty("prettyPrint", "true");

rest("api/handshake").
bindingMode(RestBindingMode.xml).
        post().id("Handshake Route").type(SessionRequest.class).outType(SessionResponse.class).to("bean:restHandshakeApi?method=testHandshake");

rest("api/message").
        produces("application/json").
        get().id("GetMessages").to("bean:restMessageApi?method=getAllMessages");