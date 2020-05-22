//**********Method to send email 
public void sendEmail(){ 
                new AsyncTask<Void, Void, Void>() {
                @Override
                protected void onPostExecute(Void result) {
                    Toast.makeText(MainActivity.this,
                            "Your message was sent successfully.",
                            Toast.LENGTH_SHORT).show();

                    super.onPostExecute(result);
                }

                @Override
                protected Void doInBackground(Void... params) {


                        String respond = POST(
                                URL,
                                makeMandrillRequest(fromEmail.getText()
                                        .toString(), toEmail.getText()
                                        .toString(), name.getText()
                                        .toString(), text.getText()
                                        .toString(), htmlText.getText()
                                        .toString()));
                        Log.d("respond is ", respond);


                    return null;
                }
            }.execute();
}

//*********method to post json to uri
    public String POST(String url , JSONObject jsonObject) {
    InputStream inputStream = null;
    String result = "";
    try {


        Log.d("internet json ", "In post Method");
        // 1. create HttpClient
        DefaultHttpClient httpclient = new DefaultHttpClient();
        // 2. make POST request to the given URL
        HttpPost httpPost = new HttpPost(url);
        String json = "";

        // 3. convert JSONObject to JSON to String
        json = jsonObject.toString();

        StringEntity se = new StringEntity(json);

        // 4. set httpPost Entity
        httpPost.setEntity(se);

        // 5. Set some headers to inform server about the type of the
        // content
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        // 6. Execute POST request to the given URL
        HttpResponse httpResponse = httpclient.execute(httpPost);

        // 7. receive response as inputStream
        inputStream = httpResponse.getEntity().getContent();

        // 8. convert inputstream to string
        if(inputStream != null){
            result = convertStreamToString(inputStream);
        }else{
            result = "Did not work!";
            Log.d("json", "Did not work!" );
        }
    } catch (Exception e) {
        Log.d("InputStream", e.toString());
    }

    // 9. return result
    return result;
}





//*****************TO create email json
     private JSONObject makeMandrillRequest(String from, String to, String name,
        String text, String htmlText) {

    JSONObject jsonObject = new JSONObject();
    JSONObject messageObj = new JSONObject();
    JSONArray toObjArray = new JSONArray();
    JSONArray imageObjArray = new JSONArray();
    JSONObject imageObjects = new JSONObject();
    JSONObject toObjects = new JSONObject();

    try {
        jsonObject.put("key", "********************");

        messageObj.put("html", htmlText);
        messageObj.put("text", text);
        messageObj.put("subject", "testSubject");
        messageObj.put("from_email", from);
        messageObj.put("from_name", name);

        messageObj.put("track_opens", true);
        messageObj.put("tarck_clicks", true);
        messageObj.put("auto_text", true);
        messageObj.put("url_strip_qs", true);
        messageObj.put("preserve_recipients", true);

        toObjects.put("email", to);
        toObjects.put("name", name);
        toObjects.put("type", "to");

        toObjArray.put(toObjects);

        messageObj.put("to", toObjArray);
        if (encodedImage != null) {
            imageObjects.put("type", "image/png");
            imageObjects.put("name", "IMAGE");
            imageObjects.put("content", encodedImage);

            imageObjArray.put(imageObjects);
            messageObj.put("images", imageObjArray);
        }

        jsonObject.put("message", messageObj);

        jsonObject.put("async", false);



        Log.d("Json object is ", " " + jsonObject);

    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return jsonObject;
}