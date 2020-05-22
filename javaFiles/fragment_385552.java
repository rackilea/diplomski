HttpTransport transport = new ApacheHttpTransport();
HttpRequestFactory requestFactory = transport.createRequestFactory();
HttpRequest request = requestFactory.buildGetRequest(url);
HttpResponse response = request.execute();
     try {
       // process the HTTP response object
           InputStream is = response.getContent();
           try {
               // Process the input stream..
           } finally {
               is.close();
           }
     } finally {
       response.disconnect();
     }