String script =  "register_phone.php";
String serverUrl = SERVER_URL + script;
Map<String, String> params = new HashMap<String, String>();
params.put("regId", regId);
params.put("devId", devId);
params.put("projId", projId);
params.put("owner", owner);

// some other largely irrelevant stuff
post(serverUrl, params);




private static void post(String endpoint, Map<String, String> params)
            throws IOException {
        String url = null;
        url = endpoint;
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        Iterator<Entry<String, String>> iterator = params.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<String, String> param = iterator.next();
            String key = param.getKey();
            String value = param.getValue();
            nameValuePairs.add(new BasicNameValuePair(key, value));
        }

        HttpResponse response;
        final HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, NETWORK_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParams, NETWORK_TIMEOUT);
        HttpConnectionParams.setStaleCheckingEnabled(httpParams, true);
        HttpClient httpClient = new DefaultHttpClient(httpParams);
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            response = httpClient.execute(httpPost);
             //int status = httpClient.getResponseCode();
            Log.d(GCMTAG, "response " + response.getEntity());
            String responseBody = "empty";
            responseBody = EntityUtils.toString(response.getEntity());
            Log.d(GCMTAG, "responsebody " + responseBody);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

}