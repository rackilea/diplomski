HttpURLConnection urlConn;
URL mUrl = new URL(url);
urlConn = (HttpURLConnection) mUrl.openConnection();
...
//query is your body
urlConn.addRequestProperty("Content-Type", "application/" + "POST");
if (query != null) {
urlConn.setRequestProperty("Content-Length", Integer.toString(query.length()));
urlConn.getOutputStream().write(query.getBytes("UTF8"));
}