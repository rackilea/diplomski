ConfigurationBuilder cb = new ConfigurationBuilder();
      cb.setDebugEnabled(true).setOAuthConsumerKey("")
              .setOAuthConsumerSecret("")
              .setOAuthAccessToken("")
              .setOAuthAccessTokenSecret("");

      TwitterStream twitterStream = new TwitterStreamFactory(cb.build())
              .getInstance();