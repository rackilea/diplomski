public static long uploadActivity(String bearer, String fileName) {
    JSONObject jsonObj = null;

    HttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(
            "https://www.strava.com/api/v3/uploads");
    httpPost.addHeader("Authorization", "Bearer " + bearer);
    httpPost.setHeader("enctype", "multipart/form-data");

    MultipartEntity reqEntity = new MultipartEntity(
            HttpMultipartMode.BROWSER_COMPATIBLE);
    try {
        reqEntity.addPart("activity_type", new StringBody("ride"));
        reqEntity.addPart("data_type", new StringBody("fit"));
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    FileBody bin = new FileBody(new File(fileName));
    reqEntity.addPart("file", bin);

    httpPost.setEntity(reqEntity);

    HttpResponse response;
    try {
        response = httpClient.execute(httpPost);

        HttpEntity respEntity = response.getEntity();

        if (respEntity != null) {
            // EntityUtils to get the response content
            String content = EntityUtils.toString(respEntity);
            System.out.println(content);
            JSONParser jsonParser = new JSONParser();
            jsonObj = (JSONObject) jsonParser.parse(content);
        }
    } catch (ParseException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 

    return (long) jsonObj.get("id");
}