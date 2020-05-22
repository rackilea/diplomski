public static void main( String[] args ) throws IllegalStateException, IOException
{
    HttpClient client = new DefaultHttpClient();
    HttpGet request = new HttpGet("http://ifconfig.me/");
    request.setHeader("User-Agent","curl/7.16.3 (i686-pc-cygwin) libcurl/7.16.3 OpenSSL/0.9.8h zlib/1.2.3 libssh2/0.15-CVS");
    HttpResponse response = client.execute(request);

    // Get the response
    String addr = IOUtils.toString(new InputStreamReader(response.getEntity().getContent()));
    System.out.println(addr);
}