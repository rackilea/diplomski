public boolean send(String data) {

    DefaultHttpClient httpclient = null;
    boolean success = false;

    try {           
        httpclient = new DefaultHttpClient();

        String url = "your URL";


        HttpPost httpost = new HttpPost(url);

        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("sub", data));


        httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));


        HttpResponse response = httpclient.execute(httpost);

        HttpEntity entity = response.getEntity();

        if (entity != null) {

            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            if(statusCode != 200){
                mResErr.onErrorResponse(statusCode);                    
            }

            InputStream is = entity.getContent();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ( (line = br.readLine()) != null) {

                // get data from line


            }
            is.close();


        } else {
            //response is null/
        }
        success = true;

        mRes.onHttpResponse(mArr);


    } catch (Exception e) {
        mResErr.onErrorResponse(e);
        e.getStackTrace();
    }

    if (httpclient != null) {
        // resource cleanup
        httpclient.getConnectionManager().shutdown();
    }

    return success;
}