public void sendTweet(SharedPreferences prefs,String msg) throws Exception {
    String token = prefs.getString(OAuth.OAUTH_TOKEN, "");
    String secret = prefs.getString(OAuth.OAUTH_TOKEN_SECRET, "");

    AccessToken a = new AccessToken(token,secret); 

    Twitter twitter = new TwitterFactory().getInstance();
    twitter.setOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
    twitter.setOAuthAccessToken(a);
    twitter.updateStatus(msg);
}