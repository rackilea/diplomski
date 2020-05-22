for(int i = 0; i < arr.length(); i++) {
   JSONObject t = (JSONObject) arr.get(i);
   Tweet tweet = new Tweet(
     t.get("from_user").toString(),
     t.get("text").toString(),
     t.get("profile_image_url").toString()
   );
   tweets.add(tweet);
 }