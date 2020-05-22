public static void testWS(){

    try{
        SumRequest sumRequest = new SumRequest(1,4); //here you have to create your input object
        Client client = Client.create();
        WebResource service = client.resource("http://www.madbit.org/SumService");
         /*
          * here you are calling the post method with your input object attached               
          */  
        ClientResponse response = service.type(MediaType.APPLICATION_XML).post(ClientResponse.class, sumRequest); 
        SumResponse res = response.getEntity(SumResponse.class);
        System.out.println("output JaxbWS:\n " + res.toString());
    }
    catch(Exception e){
         System.out.println(e.getMessage()); 
    }