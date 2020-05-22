ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
              .setOAuthConsumerKey("*******")
              .setOAuthConsumerSecret("****")
              .setOAuthAccessToken("*****")
              .setOAuthAccessTokenSecret("*****");
            TwitterFactory tf = new TwitterFactory(cb.build());
            final Twitter twitter = tf.getInstance();
            Query query = new Query("source:twitter4j yusukey");

            new Thread(new Runnable() { 
                @Override
                public void run() {
                    try {
                        QueryResult result = twitter.search(query);
                        for (Status status : result.getTweets()) {
                                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                        }
                    } catch (TwitterException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }).start();