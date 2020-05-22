InputStream rstream;
try {
    HttpResponse response = client.execute(HttpHost, method);
    rstream = response.getEntity().getContent();
} catch (IOException e) {
    return BadSpot(e.getMessage()); 
}