import org.apache.http.HttpResponse;
    import org.apache.http.client.HttpClient;
    import org.apache.http.client.methods.HttpGet;
    .........
public InputStream getConnectionStream(String fullUrl){
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(fullUrl);
        HttpResponse response = client.execute(request);
        InputStream is = response.getEntity().getContent();

        return is;
}