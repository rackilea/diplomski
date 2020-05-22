public HttpResponse YourMethod(String lat,String lon,Strig url) {
         HttpResponse response =null;
           // Create a new HttpClient and Post Header
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new    HttpPost(url);

     try {

    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
    nameValuePairs.add(new BasicNameValuePair(<lat key from php>, lat));
    nameValuePairs.add(new BasicNameValuePair(<lat key from php>, lon));
    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));


    HttpResponse response = httpclient.execute(httppost);

     } catch (Exception e) {

   }
    finally{
       return response 
      }

 }