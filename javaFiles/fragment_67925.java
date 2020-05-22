TextView textv=(TextView) findViewById(R.id.textv);

    try {
        HttpClient client = new DefaultHttpClient();  
        String URL = "http://server/WebService.asmx/Get_EventList";
        HttpPost post = new HttpPost(URL);


        JSONObject json = new JSONObject();
        json.put("FairId", "2");
        StringEntity se = new StringEntity( json.toString());  
        se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(se);

        HttpResponse responsePost = client.execute(post);
        HttpEntity resEntityPost = responsePost.getEntity();  
        if (resEntityPost != null) 
        {
            String response=EntityUtils.toString(resEntityPost);
            Log.e("XXX",response);
            textv.setText(response);
        }
    } catch (Exception e) {
        e.printStackTrace();
        textv.setText(e.toString());
        Log.e("hata!!",e.toString());
    }