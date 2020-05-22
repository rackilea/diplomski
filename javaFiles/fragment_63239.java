private class Task extends AsyncTask<JSONObject, Void, JSONObject>{
    @Override
    protected JSONObject doInBackground(JSONObject... params) {
        try {
            JSONParser json_parser = new JSONParser();
            json_object = json_parser.getJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json_object;
    }

    @Override
    protected void onPostExecute(JSONObject result){
        LoadEmployee(result);
    }
}

private class JSONParser {
    .....
    public JSONObject getJson(String url) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpget);
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            StringBuffer hasil = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                hasil.append(line);
            }
            json = hasil.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jObj;
    }
}