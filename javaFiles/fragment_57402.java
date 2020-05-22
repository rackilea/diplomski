public void clickbutton(View v) {
    try {
        // http://androidarabia.net/quran4android/phpserver/connecttoserver.php

        // Log.i(getClass().getSimpleName(), "send  task - start");
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams,
                TIMEOUT_MILLISEC);
        HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
        //
        HttpParams p = new BasicHttpParams();
        // p.setParameter("name", pvo.getName());
        p.setParameter("user", "1");

        // Instantiate an HttpClient
        HttpClient httpclient = new DefaultHttpClient(p);
        String url = "http://10.0.2.2:8080/sample1/" + 
                     "webservice1.php?user=1&format=json";
        HttpPost httppost = new HttpPost(url);

        // Instantiate a GET HTTP method
        try {
            Log.i(getClass().getSimpleName(), "send  task - start");
            //
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
                    2);
            nameValuePairs.add(new BasicNameValuePair("user", "1"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httppost,
                    responseHandler);
            // Parse
            JSONObject json = new JSONObject(responseBody);
            JSONArray jArray = json.getJSONArray("posts");
            ArrayList<HashMap<String, String>> mylist = 
                   new ArrayList<HashMap<String, String>>();

            for (int i = 0; i < jArray.length(); i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                JSONObject e = jArray.getJSONObject(i);
                String s = e.getString("post");
                JSONObject jObject = new JSONObject(s);

                map.put("idusers", jObject.getString("idusers"));
                map.put("UserName", jObject.getString("UserName"));
                map.put("FullName", jObject.getString("FullName"));

                mylist.add(map);
            }
            Toast.makeText(this, responseBody, Toast.LENGTH_LONG).show();

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Log.i(getClass().getSimpleName(), "send  task - end");

    } catch (Throwable t) {
        Toast.makeText(this, "Request failed: " + t.toString(),
                Toast.LENGTH_LONG).show();
    }
}