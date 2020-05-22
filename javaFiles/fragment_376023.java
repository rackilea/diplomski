CloseableHttpClient httpclient = HttpClients.createDefault();
ObjectMapper mapper = new ObjectMapper();
TestObj obj = new TestObj();
obj.setFile(IOUtils.toByteArray(new FileInputStream(new File("C:\\download.jpg"))));
obj.setMimetype("image/jpeg");
obj.setDescription("asd");
String jsonInString = mapper.writeValueAsString(obj);
HttpPost httpPost = new HttpPost("http://localhost:8080/url");
httpPost.setHeader("Authorization", "Bearer asdf");
httpPost.setHeader("Content-type", "application/json");
StringEntity se = new StringEntity(jsonInString);
httpPost.setEntity(se);
System.out.println(httpPost.toString());
CloseableHttpResponse response2 = httpclient.execute(httpPost);
try {
    System.out.println("!!!! " + jsonInString);
    System.out.println("!!!! " + se.toString());
    System.out.println("!!!! " + response2.getStatusLine());
    HttpEntity entity2 = response2.getEntity();
    EntityUtils.consume(entity2);
} finally {
    response2.close();
}