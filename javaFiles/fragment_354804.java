MyWebServiceRequest mywebService = new MyWebServiceRequest();


   for(int i=0; i< 9; i++){
       MyRequestType type= new MyRequestType ();
       type.setA(1);
       type.setB(2);
       mywebService.add(type);
   }