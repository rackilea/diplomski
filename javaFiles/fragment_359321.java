String uname=";
     uname="hello"; //some operation
    //create one XML string
    String sendThis="<?xml version='1.0'?>"
            +"<Maintag>"
            +"<Subtag>"
            +"<unameVal>"+uname+"</unameVal>"     
            +"</Subtag>"
            +"</Maintag>"
  out.print(sendThis);