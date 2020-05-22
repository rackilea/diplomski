private void downloadFile(String url, String destination) throws ParserConfigurationException, FileNotFoundException, SAXException, UnsupportedEncodingException, ClientProtocolException, IllegalStateException, IOException {
    if(isNetworkAvailable(this)){
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        MultipartEntity reqEntity = new  MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        get.setHeader("user_id", user_id);
        reqEntity.addPart("user_id", new StringBody(user_id));
        HttpResponse response = client.execute(get);  
        HttpEntity resEntity = response.getEntity();
        if (resEntity != null) {
            String serverResponse = EntityUtils.toString(resEntity);
            BufferedWriter out = new BufferedWriter(new FileWriter(destination));
            out.write(serverResponse);
            out.close();
        }
    }
}