SoapObject ks= (SoapObject)env.bodyIn;
    SoapObject inner = (SoapObject)ks.getProperty("return");
    String Status = inner.getProperty("Status").toString();
    String Data = inner.getProperty("Data").toString();


    //System.out.println(ht.requestDump);
    //System.out.println(ht.responseDump);

    System.out.println(Status.trim());
    System.out.println(Data.trim());