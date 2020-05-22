Client client = Client.create();
  WebResource webResource = client
        .resource("http://localhost:8080/activiti-rest/service/login");
  LoginInfo loginInfo = new LoginInfo();
  loginInfo.userId = "kermit";
  loginInfo.password = "kermit";
  ClientResponse response;
  try {
     response = webResource.type("application/json").post(ClientResponse.class, loginInfo);
     System.out.print(response.toString());
  } catch (UniformInterfaceException ue) {
     System.out.print(ue.getMessage());
  }