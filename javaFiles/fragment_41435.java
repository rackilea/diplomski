long startTime = System.currentTimeMillis();

     //Write this above before your httprequest 

          HttpResponse httpResponse = httpClient.execute(httpGet);
          HttpEntity httpEntity = httpResponse.getEntity();
          is = httpEntity.getContent();    

    //After you get response  

    long elapsedTime = System.currentTimeMillis() - startTime;
    System.out.println("Total elapsed http request/response time in milliseconds: " + elapsedTime);