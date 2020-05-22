public HttpURLConnection getHttpConn(String webservice_url) throws IOException {
URL endpoint = new URL(webservice_url);
URLConnection connection = endpoint.openConnection();
HttpURLConnection httpConn = (HttpURLConnection) connection;
byte[] encodedBytes = Base64.encodeBase64((getUsername()+":"+getPassword()).getBytes());
httpConn.setRequestMethod(getRequestMethod());
httpConn.setRequestProperty(HTTP_ACCEPT_ENCODING, getAccept_Encoding());
httpConn.setRequestProperty(HTTP_CONTENT_TYPE, getContentType());
httpConn.setRequestProperty(getContent_Length(), getContent_Length());
httpConn.setRequestProperty(HTTP_HOST, getHost());
httpConn.setRequestProperty(getConnection(), getConnection());
httpConn.setRequestProperty(HTTP_COOKIE2, getCookie2());
httpConn.setRequestProperty(HTTP_COOKIE, getCookie());
httpConn.setRequestProperty("Authorization", "Basic "+new String(encodedBytes));
httpConn.setDoOutput(true);
httpConn.setDoInput(true);
return httpConn;
}