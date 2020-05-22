try {
        // create http connection
        HttpClient client = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);

        // connect
        HttpResponse response = client.execute(httpget);

        // get response
        HttpEntity entity = response.getEntity();

        if(entity == null) {
            msg = "No response from server";
            return null;
        }

        // get response content and convert it to json string
        InputStream is = entity.getContent();
        return streamToString(is);
    }
    catch(IOException e){
        msg = "No Network Connection";
    }