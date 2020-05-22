HttpClient httpclient = new DefaultHttpClient();
    HttpResponse response;
    String _username = "username";
    String _password = "password";
    try {
         ((AbstractHttpClient) httpclient).getCredentialsProvider().setCredentials(
                new org.apache.http.auth.AuthScope(webhostname, webport)),
                new org.apache.http.auth.UsernamePasswordCredentials(_username, _password));

        response = httpclient.execute(new HttpGet(completeurlhere));
        StatusLine statusLine = response.getStatusLine();
        if(statusLine.getStatusCode() == HttpStatus.SC_OK) {
            try {
                InputStream is = response.getEntity().getContent();
                this._data = is;

            } catch(Exception ex) {
                Log.e("DBF Error",ex.toString());
            }                
        } else {
            response.getEntity().getContent().close();
            throw new IOException(statusLine.getReasonPhrase());
        }
    } catch(ClientProtocolException cpe) {
        Log.e("ClientProtocolException @ at FPT",cpe.toString());
    } catch(Exception ex) {
        Log.e("Exception at FETCHPROJECTASK",ex.toString());
    }