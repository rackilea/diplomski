HttpClient httpclient = new DefaultHttpClient();
    // Prepare a request object
    HttpGet httpget = new HttpGet(url); 
    // Execute the request
    HttpResponse response;

    JSONArray arr = new JSONArray();
    try {
       response = httpclient.execute(httpget);

       HttpEntity entity = response.getEntity();

       if (entity != null && response.getStatusLine().getStatusCode() == 200) {
                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                String result = convertStreamToString(instream);
                arr=new JSONArray(result);
                instream.close();

            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            Log.e(TAG,e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Log.e(TAG,e.toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.e(TAG,e.toString());
        }

        return arr;


public static String convertStreamToString(InputStream is) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        Log.e(TAG + "ERROR",e.toString());

    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG + "ERRO",e.toString());
        }
    }
    return sb.toString();
}