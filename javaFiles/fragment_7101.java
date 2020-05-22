try
    {
        HttpClient   httpClient  = new DefaultHttpClient();
        HttpPost     postRequest = new HttpPost("https://google.com");
        StringEntity input       = new StringEntity("ttt");
        input.setContentType("application/json");
        postRequest.setEntity(input);
        HttpResponse response = httpClient.execute(postRequest);
    }
    catch (final Exception e)
    {
        System.out.print(e);
    }