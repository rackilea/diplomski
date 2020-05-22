public static String getStringContent(String uri, String postData, 
        HashMap<String, String> headers) throws Exception {

        HttpClient client = new DefaultHttpClient();
        HttpPost request = new HttpPost();
        request.setURI(new URI(uri));
        request.setEntity(new StringEntity(postData));
        for(Entry<String, String> s : headers.entrySet())
        {
            request.setHeader(s.getKey(), s.getValue());
        }
        HttpResponse response = client.execute(request);

        InputStream ips  = response.getEntity().getContent();
        BufferedReader buf = new BufferedReader(new InputStreamReader(ips,"UTF-8"));
        if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK)
        {
            throw new Exception(response.getStatusLine().getReasonPhrase());
        }
        StringBuilder sb = new StringBuilder();
        String s;
        while(true )
        {
            s = buf.readLine();
            if(s==null || s.length()==0)
                break;
            sb.append(s);

        }
        buf.close();
        ips.close();
        return sb.toString();

 }