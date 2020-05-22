MyWebServiceRequest mywebService = new MyWebServiceRequest();
   MyRequestType type= new MyRequestType ();

   for(int i=0; i< 9; i++){
       type.setA(1);
       type.setB(2);
       mywebService.add(type);
   }