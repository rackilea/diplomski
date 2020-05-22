import org.apache.http.util.EntityUtils;

public String fetchPage(String part){
    log.info("fetchPage STARTING");
    long start = System.currentTimeMillis();

    String reply;

    String searchurl = URL + URL_SEARCH_BASE + part + URL_SEARCH_TAIL;

    HttpClient httpclient = new DefaultHttpClient();
    HttpGet httpget = new HttpGet(searchurl);
    HttpResponse response;
    try {
        response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            return EntityUtils.toString(entity);
        }
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return null;
}