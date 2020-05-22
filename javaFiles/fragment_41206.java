try {
    Credentials credentials = new UsernamePasswordCredentials("admin", "password");  //-u admin:password
    DefaultHttpClient httpClient = new DefaultHttpClient();
    httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
    HttpPut put = new HttpPut("http://localhost:8080/my-server/file.ext");  //-X PUT
    put.setEntity(new FileEntity(new File("/absolute/path/file/to/upload/file.ext"), "image/png"));  //@ - absolute path
    httpClient.execute(put);
} catch(Exception e) {
    //-f, fail silently
}