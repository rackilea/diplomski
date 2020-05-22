public JSONObject getJSONFromUrl(String url, String username,
            String password,  String photo_path) {
InputStream is = null;
    JSONObject jObj = null;
    static String jsonResp = "";
    String CONTENT_TYPE_JSON = "application/json";
    static String json = "";
    Context context;

        try {
            File file = null;
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            MultipartEntity entity = new MultipartEntity(
                    HttpMultipartMode.BROWSER_COMPATIBLE);

            if(photo_path != null)
                file = new File(photo_path);

            //temp end
            entity.addPart("username", new StringBody(username));
            entity.addPart("password", new StringBody(password));

            entity.addPart("file", new FileBody(file));
            entity.addPart("filetype",new StringBody("jpeg"));
            // entity.addPart("photo", new
            // StringBody("/storage/sdcard0/Download/1.jpg"));
            httpPost.setEntity(entity);

            Log.d("URL Request: ", url.toString());

            HttpResponse httpResponse = httpClient.execute(httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();

            if (code != 200) {
                Log.d("HTTP response code is:", Integer.toString(code));
                return null;
            } else {
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
            }
        } catch (ConnectTimeoutException e) {
            // TODO: handle exception

            Log.e("Timeout Exception", e.toString());
            return null;
        } catch (SocketTimeoutException e) {
            // TODO: handle exception
            Log.e("Socket Time out", e.toString());
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            jsonResp = sb.toString();

            Log.d("Content: ", sb.toString());

        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting Response " + e.toString());
            return null;
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(jsonResp);

        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON Object
        return jObj;
    }