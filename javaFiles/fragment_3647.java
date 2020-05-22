@WebMethod(operationName = "getPojo" )
   public Pojo getPojo(@WebParam(name = "pojo") Pojo pjRequest){

  System.out.println("Pojo name is "+pjRequest.getPojoName());

   return new Pojo(234,"IM new Pojo");
 }
    }