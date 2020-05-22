public static void launchApi() 
{
    try 
    {
        //  Uncomment this if your server cert is not signed by a trusted CA              
        HostnameVerifier hv = new HostnameVerifier() 
        {
            public boolean verify(String urlHostname, SSLSession session)
            {
                return true;
            }};

        HttpsURLConnection.setDefaultHostnameVerifier(hv);


        URL url = new URL("https://myRootUrl.com/to/launch/api");

        HttpsURLConnection.setDefaultSSLSocketFactory(getSocketFactory());
        HttpsURLConnection urlConn = (HttpsURLConnection)url.openConnection();

        String encoded = Base64.getEncoder().encodeToString((userName+":"+userPwd).getBytes(StandardCharsets.UTF_8));  //Acc User Credentials if needed to log in
        urlConn.setRequestProperty ("Authorization", "Basic "+encoded);
        urlConn.setRequestMethod("GET"); // Specify all needed Request Properties:
        urlConn.setRequestProperty("Accept", "application/json;charset=UTF8");
        urlConn.setRequestProperty("Cache-Control", "no-cache");

        urlConn.connect();

        /* Dump what we have found */
        BufferedReader in = 
            new BufferedReader(
                    new InputStreamReader(urlConn.getInputStream()));
        String inputLine = null;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}