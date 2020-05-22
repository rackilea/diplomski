Client client = ClientBuilder.newBuilder().build();
    WebTarget target = client
            .target("http://localhost:8080/");
    Response response = target.request().get();
    Message message = client.readEntity(Message.class);
     /*
     // now.. process the message
     for (Message message : message.get...) {.. }
    */
    response.close(); // close connections.