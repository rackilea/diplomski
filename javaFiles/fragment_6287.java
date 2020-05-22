String USER_URI = "http://localhost:8080/AnyQserver/rest/users";
    User user = new anyq.server.common.bean.User();
    user.setUserId(15);
    user.setUserName("asd");
    user.setUserPassword("asd");

    Client client = Client.create();
    String request = new Gson().toJson(user);
    System.out.println(request);
    WebResource r = client.resource(USER_URI);
    ClientResponse response = r.type(MediaType.APPLICATION_JSON).post(
            ClientResponse.class, request);
    System.out.println(response.getStatus());