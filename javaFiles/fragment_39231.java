OAuthConsumer consumer = new DefaultOAuthConsumer(
            "vLrlKnO7XgdH3eu4dvcG5BU9QwCtrQ",
            "AdsphqRmHTvhtZLyiNoCeliLJP2NXZ");
    consumer.setTokenWithSecret(null, null); //i pass token as access token as a null as my server dont need it.

    // create an HTTP request to a protected resource
    URL url = new URL(
            "http://www.mywebservice.com");
    HttpURLConnection request = (HttpURLConnection) url.openConnection();

    // sign the request
    consumer.sign(request);

    // send the request
    request.connect();

    InputStream in = new BufferedInputStream(request.getInputStream());
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    StringBuilder out = new StringBuilder();
    String line = "";
    while ((line = reader.readLine()) != null) {
        out.append(line);
    }
    System.out.println(out.toString());