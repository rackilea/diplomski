ConfigurationBuilder cb = new ConfigurationBuilder();
       cb.setDebugEnabled(true)
            .setOAuthConsumerKey("")
            .setOAuthConsumerSecret("")
            .setOAuthAccessToken("")
            .setOAuthAccessTokenSecret("");
 TwitterFactory tf=new TwitterFactory(cb.build());  
 twitter4j.Twitter tw=tf.getInstance();