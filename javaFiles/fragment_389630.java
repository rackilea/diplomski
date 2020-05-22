String url = "https://www.playstation.com/en-us/";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", USER_AGENT);
     //This is the http response code :  
    int responseCode = con.getResponseCode();

    // To actually get the html body text, read the stream, 
    // below is just one of many ways to to this:

    BufferedReader in = new BufferedReader(
    new InputStreamReader(obj.openStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
        System.out.println(inputLine); //<-- prints each line of html                  
    in.close();