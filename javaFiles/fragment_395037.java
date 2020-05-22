// yourID
String userID = "";
String albumID = "";
String photoID = "";

HttpPost postRequest = new HttpPost(
    "https://picasaweb.google.com/data/feed/api/user/" + userID
    + "/albumid/" + albumID + "/photoid/" + photoID);

postRequest.addHeader(new BasicHeader("GData-Version", "2.0"));
postRequest.addHeader(new BasicHeader("Authorization",
    "GoogleLogin auth=" + mAuthToken));

String content = 
    "<entry xmlns='http://www.w3.org/2005/Atom'>"
    + "<content>" + comment + "</content>"
    + "<category scheme='http://schemas.google.com/g/2005#kind'"
    + " term='http://schemas.google.com/photos/2007#comment'/>"
    + "</entry>";

try {
    StringEntity entity = new StringEntity(content);
    entity.setContentType(new BasicHeader("Content-Type",
        "application/atom+xml"));
    postRequest.setEntity(entity);

    HttpClient httpclient = new DefaultHttpClient();
    HttpResponse response = httpclient.execute(postRequest);

} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
} catch (ClientProtocolException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}