try {
    final HttpClient httpClient = new DefaultHttpClient();
    final HttpGet httpGet = new HttpGet("http://SERVLET_URL/");
    HttpResponse response = httpClient.execute(httpGet);
    final HttpEntity entity = response.getEntity();
    Log.i(TAG, "Servlet Result: " + EntityUtils.toString(entity));
} catch (ClientProtocolException e) {
    Log.e(TAG, "ClientProtocolException", e);
} catch (ParseException e) {
    Log.e(TAG, "ParseException", e);
} catch (IOException e) {
    Log.e(TAG, "IOException", e);
}