ConfigurationBuilder twitterConfigBuilder = new ConfigurationBuilder();
twitterConfigBuilder.setOAuthConsumerKey("consumerKey");
twitterConfigBuilder.setOAuthConsumerSecret("consumerSecret");
twitterConfigBuilder.setOAuthAccessToken("accessToken");
twitterConfigBuilder.setOAuthAccessTokenSecret("accessTokenSecret");

TwitterListener twitterListener = new TwitterListener();

TwitterStream twitterStream
        = new TwitterStreamFactory(twitterConfigBuilder.build()).getInstance();

// Register your Listener
twitterStream.addListener(twitterListener);

FilterQuery query = new FilterQuery();
ArrayList<String> trackList = new ArrayList<String>();
// TODO, add the list of words you want to track
query.track(trackList.toArray(new String[trackList.size()]));

twitterStream.filter(query);