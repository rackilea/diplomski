InputStream inputStream = null;
        String result = "";
        String url = [YOUR URL HERE];

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            String json1 = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("key", message);

            json1 = jsonObject.toString();
            StringEntity se = new StringEntity(json1);
            httpPost.setEntity(se);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse httpResponse = httpclient.execute(httpPost);

            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if (inputStream != null) {
                result = convertInputStreamToString(inputStream);
                myJSON = result;
            } else {
                result = "Did not work!";
            }
        } catch (Exception e) {
               Log.d("InputStream", e.getLocalizedMessage());
}