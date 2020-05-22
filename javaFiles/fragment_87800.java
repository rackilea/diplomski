Query query = new Query("football");
    QueryResult result;
    int Count=0;
    do {
        result = twitter.search(query);
        List<Status> tweets = result.getTweets();
        for (Status tweet : tweets) {
          System.out.println("@" + tweet.getUser().getScreenName() + ":" + tweet.getText());
            Count++;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    while ((query = result.nextQuery()) != null);
    System.out.println(Count);
    System.exit(0);