public static void main(String[] args) {

    ConfigurationBuilder cb = new ConfigurationBuilder();

    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("Your Cosumer Key")
      .setOAuthConsumerSecret("Your Consumer Secret")
      .setOAuthAccessToken("Your Access Token")
      .setOAuthAccessTokenSecret("Your Access Token Secret");
    TwitterFactory tf = new TwitterFactory(cb.build());

    Twitter twitter = tf.getInstance();

    List<Status> statusList = null;

   try {
        statusList = twitter.getUserTimeline("@Citi");
    } catch (TwitterException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    for (Status status : statusList) {
        System.out.println(status.toString());
    }        
}