final CloseableHttpClient httpClient = HttpClientBuilder
        .create()
        .setSSLContext(this.http.createSSLContext())
        .setProxy(new HttpHost(InetAddress.getByName(ip), port))
        .build();
final HttpEntity requestEntity = MultipartEntityBuilder
        .create()
        .addBinaryBody("upload", new File("src/main/resources/XML/example.xml")) // Hardcoded for testing
        .build();

final HttpPost post = new HttpPost(https://api.url.com/in/upload.php);
post.setEntity(requestEntity);

try (CloseableHttpResponse response = httpClient.execute(post)) {
    this.logger.info(response.getStatusLine().toString());
    EntityUtils.consume(response.getEntity());
}