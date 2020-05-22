DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(webPage);

        NTCredentials credentials = new NTCredentials(username, password, workstation, domain);


        httpClient.getCredentialsProvider().setCredentials(new AuthScope(server,port), credentials);

        HttpResponse response = httpClient.execute(getRequest);