try {
        HttpGet httpget = new HttpGet(query);
        httpget.setHeader("Accept", "application/json");
        System.out.println("Executing request " + httpget.getRequestLine());
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println(responseBody);
        }catch(Exception e){   //Not really necessary
            e.printStackTrace();  //Prints the exception in the logs
        }
        finally {
            response.close();
        }
    }catch(IOException e){  
        e.printStackTrace();
     }
     finally {
        httpclient.close();
    }