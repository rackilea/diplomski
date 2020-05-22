String accessToken = "replaceThisWithAccessToken";
    String urlString = MessageFormat.format("https://graph.facebook.com/v2.3/me/inbox?access_token={0}&&format=json&method=get",
            accessToken);
    URL url = new URL(urlString);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
    }
    bufferedReader.close();