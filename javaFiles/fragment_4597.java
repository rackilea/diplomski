try {
    HttpClient httpClient = new DefaultHttpClient();
    HttpContext localContext = new BasicHttpContext();
    HttpPost httpPost = new HttpPost(url);
    HttpResponse response = httpClient.execute(httpPost, localContext);
    InputStream in = response.getEntity().getContent();
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); //**<--What class is this?**
    Document doc = builder.parse(in); //if we step through to here, this line executes then goes directly to "x" below
    return doc;
} catch (Exception e) { //<-- Does not catch Error
    e.printStackTrace();
}
return null; //x