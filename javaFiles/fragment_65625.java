@NotThreadSafe
class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public String getMethod() {
        return METHOD_NAME;
    }

    public HttpDeleteWithBody(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    public HttpDeleteWithBody(final URI uri) {
        super();
        setURI(uri);
    }

    public HttpDeleteWithBody() {
        super();
    }
}



public String[] sendDelete(String URL, String PARAMS, String header) throws IOException {
    String[] restResponse = new String[2];
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(URL);
        StringEntity input = new StringEntity(PARAMS, ContentType.APPLICATION_JSON);
        httpDelete.addHeader("header", header);
        httpDelete.setEntity(input);  

        Header requestHeaders[] = httpDelete.getAllHeaders();
        CloseableHttpResponse response = httpclient.execute(httpDelete);
        restResponse[0] = Integer.toString((response.getStatusLine().getStatusCode()));
        restResponse[1] = EntityUtils.toString(response.getEntity());    
        return restResponse;
    }
}