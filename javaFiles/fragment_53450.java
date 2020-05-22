try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
  HttpGet httpget = new HttpGet("https://content.homenetiol.com/672/27185/640x480/4d352f4ff9cf4948a93612e91401e128.jpg");
  try (CloseableHttpResponse response = httpclient.execute(httpget);
       InputStream stream = response.getEntity().getContent()) {
    BufferedImage sourceImg = ImageIO.read(stream);
    System.out.println(sourceImg);
  }
} catch (IOException e) {
  e.printStackTrace();
}