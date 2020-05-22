String API = "https://en.wikipedia.org/w/api.php?action=query&generator=random&grnnamespace=0&prop=pageimages&format=json&pithumbsize=500&utf8";

    //open connection with wikipedia.
    HttpURLConnection httpcon = (HttpURLConnection) new URL(API).openConnection();

    //read all the input from wikipedia.
    BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
    String responseSB = in.lines().collect(Collectors.joining());
    in.close();
    JSONObject incomingJSON = new JSONObject(responseSB);

  Map<String,JSONObject> map =  (Map<String, JSONObject>) incomingJSON.getJSONObject("query").getJSONObject("pages");

  map.forEach((k,v)->{
      System.out.println(" The key is : "+k+" the title is : "+v.getString("title"));  

      //use try catch to get source because you will not get the same response every time

      String source = v.getJSONObject("thumbnail").getString("source");
  });


}