DefaultHttpClient client = new DefaultHttpClient();

    HttpGet request = new HttpGet("http://teams.host.com/_vti_bin/listdata.svc/");

    NTCredentials credentials = new NTCredentials("user", 'pass', "workstation", "Domain");

    client.getCredentialsProvider().setCredentials(new AuthScope("teams.host.com",80), credentials);

    HttpResponse response = client.execute(request);