try
  {
    Client cliente=Client.create();
    WebResource wresource=cliente.resource("http://Localhost:8084/API_FE/webresources/Facturacion/getTokenUser");
    MultivaluedMap<String,String> data=new  MultivaluedHashMap();
    data.add("User","Abraham01");
    data.add("Password","14235afe");
    ClientResponse response =wresource.queryParams(data).post(ClientResponse.class);
    String output = response.getEntity(String.class);System.out.println(output);
  }
  catch(Exception ex)
  {
      System.out.println("Error:"+ex.getMessage());
  }