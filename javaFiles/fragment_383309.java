Credentials credentials = new 
credentials.setUsername("foo");
credentials.setUsername("hashedPwd");
Client client = ClientBuilder.newClient();
Boolean result = client.target("http://xxxxx")
            .path("/user/login/1")
            .request(MediaType.TEXT_PLAIN_TYPE)
            .post(Entity.entity(credentials, MediaType.APPLICATION_XML) , Boolean.class);
    System.out.println("Result: " + result);