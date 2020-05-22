String pathToOurFile = "/data/dada.jpg"; 
String urlServer = "http://sampleserver.com";

try {
    FileInputStream fis = new FileInputStream(new File(pathToOurFile));
    HttpClient httpClient = new DefaultHttpClient();
    HttpPost postRequest = new HttpPost(urlServer);
    byte[] data = IOUtils.toByteArray(fis);
    InputStreamBody isb = new InputStreamBody(new ByteArrayInputStream(data),pathToOurFile);
    StringBody sb1 = new StringBody("someTextGoesHere");
    StringBody sb2 = new StringBody("someTextGoesHere too");
    MultipartEntity multipartContent = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
    FileBody bin = new FileBody(new File(pathToOurFile));

    multipartContent.addPart("uploadedfile", bin);
    multipartContent.addPart("name", sb1);
    multipartContent.addPart("status", sb2);
    postRequest.setEntity(multipartContent);

    HttpResponse res = httpClient.execute(postRequest);
    res.getEntity().getContent().close();
} catch (Throwable e) {
    e.printStackTrace();
}