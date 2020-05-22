public static void sendToTwitter(String tweet) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("---")
          .setOAuthConsumerSecret("---")
          .setOAuthAccessToken("---")
          .setOAuthAccessTokenSecret("---");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter t = tf.getInstance();

        try {
        t.updateStatus(tweet);
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }