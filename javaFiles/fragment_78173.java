HttpClient httpclient = HttpClients.createDefault();
HttpPost httppost = new HttpPost(
    "http://freecite.library.brown.edu/citations/create");

// Request parameters and other properties.
List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("citation", 
    "A. Bookstein and S. T. Klein, Detecting content-bearing " +
    "words by serial clustering, " +
    "Proceedings of the Nineteenth Annual International ACM SIGIR " +
    "Conference on Research and Development in Information " +
    "Retrieval, pp. 319327, 1995."));
    httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

...
response = httpclient.execute(httppost);
response.setHeader("Content-Type", "text/xml");