public JSONObject makeHttpRequest(String url, List<NameValuePair> params) {
        try {

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            if (params != null) {
                httpPost.setEntity(new UrlEncodedFormEntity(params));
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();

            is = httpEntity.getContent();

        }catch(UnsupportedEncodingException e){
            Log.e(tag + "-> EncodingError", e.toString());
            e.printStackTrace();
        }catch(ClientProtocolException e){
            Log.e(tag + "-> ProtocolError", e.toString());
            e.printStackTrace();
        }catch(IOException e){
            Log.e(tag + "-> IOError", e.toString());
            e.printStackTrace();
    }

    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;

        while((line = br.readLine())!= null){
            sb.append(line + "\n");
        }
        is.close();
        json = sb.toString();
        Log.i(tag, "-> JSON String Buffer Created");

    }catch(Exception e){
        Log.e(tag + "-> Buffer Error", "Conversion Error" + e.toString());
    }

    try{
        Log.i("tagconvertstr", "["+json+"]");
        jobj = new JSONObject(json);
        Log.i(tag, "-> JSON object Created");

    }catch(JSONException e){
        Log.e(tag + "-> JSON Parser", e.toString());
    }

    return jobj;
}