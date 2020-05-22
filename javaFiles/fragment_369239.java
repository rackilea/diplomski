TwitterFactory factory = new TwitterFactory();
    Twitter twitter = factory.getInstance();
    String twitterScreenName;
    try {
        twitterScreenName = twitter.getScreenName();

    IDs followerIDs = twitter.getFollowersIDs(twitterScreenName, -1);
    long[] ids = followerIDs.getIDs();
    for (long id : ids) {
       twitter4j.User user = twitter.showUser(id);
       //here i am trying to fetch the followers of each id
       String userScreenName = user.getScreenName();
       System.out.println("Name: " + user.getScreenName());
       System.out.println("Location:" + user.getLocation());

       IDs followerIDsOfFollowers = twitter.getFollowersIDs(user.getScreenName(), -1);
       long[]fofIDs = followerIDsOfFollowers.getIDs();
       for(long subId : fofIDs) {
           twitter4j.User user1 = twitter.showUser(subId);
           System.out.println("Follower Master:" + userScreenName +" Follower of Follower Name: " + user1.getScreenName());
           System.out.println("Location:" + user1.getLocation());

       }