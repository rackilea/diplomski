{
    String urly = "https://api.twitch.tv/helix/streams";
    URL obj = new URL(urly);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    //only 2 headers from cURL call
    con.setRequestMethod("GET");
    con.setRequestProperty("Client-ID","Ahh_got_ya");

    int responseCode = con.getResponseCode();
    System.out.println("Response Code : " + responseCode);

    BufferedReader iny = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
      String output;
      StringBuffer jsonres = new StringBuffer();

      while ((output = iny.readLine()) != null) {
          jsonres.append(output);
      }
    iny.close();

    //printing result from response
    System.out.println(response.toString());
}