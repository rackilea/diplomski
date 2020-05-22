public static String executeGet(String url) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resp = null;  
        try {

            HttpGet httpGet = new HttpGet(url);
            response = httpClient.execute(httpGet);

            int code = response.getStatusLine().getStatusCode();
            if (code == HttpURLConnection.HTTP_OK) {
                resp = EntityUtils.toString(response.getEntity());
            } else {
                // handle wrong response here
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                close(response);
            }
        }
        return resp;
}