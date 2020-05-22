public String getValuefromUrl(String url)
    {
        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            ResponseHandler<String> resHandler = new BasicResponseHandler();
            String page = httpClient.execute(httpGet, resHandler);
            Log.v("PAGE",page);
            return page;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return "zero";  

        }
    }