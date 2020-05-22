ConfigurationBuilder builder = new ConfigurationBuilder();
    builder.setOAuthConsumerKey(consumerKey);
    builder.setOAuthConsumerSecret(SecretKet);
    User user;
    AccessToken newAcc = new AccessToken(getoken, getokensecret);
    Twitter twitter = new TwitterFactory(builder.build())
            .getInstance(newAcc);
    try {
        String mUserName = twitter.getAccountSettings().getScreenName();
        user = twitter.showUser(mUserName);
        String username = user.getName();
        String email= user.getEmail();
        String oauth_uid = Integer.toString((int) user.getId());

    } catch (TwitterException e) {
        Log.v("ERROR", "API_Get_Twitter_Registration_DATA"+e.toString())
        e.printStackTrace();
    }