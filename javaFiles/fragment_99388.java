private static JSONObject post(String sUrl, String body) {
    Log.d("post", sUrl);
    Log.d("post-body", sanitizeJSONBody(body));
    HttpURLConnection connection = null;

    String authentication = "example" + ":" + "exam123ple";
    String encodedAuthentication = Base64
        .encodeToString(authentication.getBytes(), Base64.NO_WRAP);

    try {
        URL url = new URL(sUrl);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization",
            "Basic " + encodedAuthentication);
        connection.setRequestProperty("Accept-Charset", "utf-8,*");
        OutputStreamWriter streamWriter = new OutputStreamWriter(
            connection.getOutputStream());

        streamWriter.write(body);
        streamWriter.flush();
        StringBuilder stringBuilder = new StringBuilder();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStreamReader streamReader = new InputStreamReader(
                connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(
                streamReader);
            String response = null;
            while ((response = bufferedReader.readLine()) != null) {
                stringBuilder.append(response + "\n");
            }
            bufferedReader.close();

            Log.d("Post-Response",
            sanitizeJSONBody(stringBuilder.toString()));
            return new JSONObject(stringBuilder.toString());
        } else {
            Log.d("Post-Error", connection.getResponseMessage());
            return null;
        }
    } catch (Exception exception) {
        Log.e("Post-Exception", exception.toString());
        return null;
    } finally {
        if (connection != null) {
            connection.disconnect();
        }
    }
}