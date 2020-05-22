client = new HttpClient();
GetMethod get = new GetMethod(URL);
        get.setDoAuthentication(true);
        try{

            HttpResponse response = client.executeMethod(get);
            //parsing XML from response
            //System.out.println(get.getResponseBodyAsString());
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if(statusCode == 200){
                System.out.println();
              // here I need HttpResponse object to get HttpEntity
              BufferedReader buffer = new BufferedReader
                  (new InputStreamReader(response.getEntity().getContent()));
              String line = "";
              while ((line = buffer.readLine()) != null) {
                  textView.append(line);
              } 
            }
        } finally {
            get.releaseConnection();
        }