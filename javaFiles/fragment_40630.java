void setup() {

  ConfigurationBuilder cb = new ConfigurationBuilder();
  cb.setOAuthConsumerKey("xxxx");
  cb.setOAuthConsumerSecret("xxxx");
  cb.setOAuthAccessToken("xxxx");
  cb.setOAuthAccessTokenSecret("xxxx");

  Twitter twitter = new TwitterFactory(cb.build()).getInstance();
  Query query = new Query("#peace");
  int numberOfTweets = 512;
  long lastID = Long.MAX_VALUE;
  ArrayList<Status> tweets = new ArrayList<Status>();
  while (tweets.size () < numberOfTweets) {
    if (numberOfTweets - tweets.size() > 100)
      query.setCount(100);
    else 
      query.setCount(numberOfTweets - tweets.size());
    try {
      QueryResult result = twitter.search(query);
      tweets.addAll(result.getTweets());
      println("Gathered " + tweets.size() + " tweets");
      for (Status t: tweets) 
        if(t.getId() < lastID) lastID = t.getId();

    }

    catch (TwitterException te) {
      println("Couldn't connect: " + te);
    }; 
    query.setMaxId(lastID-1);
  }

  for (int i = 0; i < tweets.size(); i++) {
    Status t = (Status) tweets.get(i);

    GeoLocation loc = t.getGeoLocation();

    String user = t.getUser().getScreenName();
    String msg = t.getText();
    String time = "";
    if (loc!=null) {
      Double lat = t.getGeoLocation().getLatitude();
      Double lon = t.getGeoLocation().getLongitude();
      println(i + " USER: " + user + " wrote: " + msg + " located at " + lat + ", " + lon);
    } 
    else 
      println(i + " USER: " + user + " wrote: " + msg);
  }
}