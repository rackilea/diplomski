public static boolean saveFile(URL imgURL, String imgSavePath) {

    boolean isSucceed = true;

    CloseableHttpClient httpClient = HttpClients.createDefault();

    HttpGet httpGet = new HttpGet(imgURL.toString());
    httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.11 Safari/537.36");
    httpGet.addHeader("Referer", "https://www.google.com");

    try {
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity imageEntity = httpResponse.getEntity();

        if (imageEntity != null) {
            FileUtils.copyInputStreamToFile(imageEntity.getContent(), new File(imgSavePath));
        }

    } catch (IOException e) {
        isSucceed = false;
    }

    httpGet.releaseConnection();

    return isSucceed;
}