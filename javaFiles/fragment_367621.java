Uri uri = new Uri.Builder()
    .scheme("http")
    .authority("example.com")
    .path("someservlet")
    .appendQueryParameter("param1", foo)
    .appendQueryParameter("param2", bar)
    .build();

HttpGet request = new HttpGet(uri.toString());

// This looks very tempting but does NOT set request parameters
// but just HttpClient configuration parameters:
// HttpParams params = new BasicHttpParams();
// params.setParameter("q", query);
// request.setParams(params);

HttpResponse response = defaultClient.execute(request);
String json = EntityUtils.toString(response.getEntity());