public class TweetUserInfo {
private Set<Twitter> mTwitterConnectorsSet;
private BufferedReader mUserFileReader;

TweetUserInfo(){
    mTwitterConnectorsSet = new HashSet<Twitter>();
}

private void initTweetConnectors(String inFile) {
    BufferedReader br = null;
    try {
        String line = null;
        String[] lines = new String[4];
        int linesIndex = 0;
        br = new BufferedReader(new FileReader(inFile));

        while ((line = br.readLine()) != null) {
            if (linesIndex == 4) {
                createAndAddTwitterConnector(lines);
                linesIndex = 0;
            }
            lines[linesIndex] = line;
            ++linesIndex;
        }
        if (linesIndex == 4) {
            createAndAddTwitterConnector(lines);
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null)br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

private void createAndAddTwitterConnector(String[] lines) {
    ConfigurationBuilder twitterConfigBuilder = new ConfigurationBuilder();
    twitterConfigBuilder.setDebugEnabled(true);

    for (int i = 0; i < lines.length; ++i) {
        String[] input = lines[i].split("=");

        if (input[0].equalsIgnoreCase("consumerkey")) {
            twitterConfigBuilder.setOAuthConsumerKey(input[1]);
        }
        if (input[0].equalsIgnoreCase("consumersecret")) {
            twitterConfigBuilder.setOAuthConsumerSecret(input[1]);
        }
        if (input[0].equalsIgnoreCase("accesstoken")) {
            twitterConfigBuilder.setOAuthAccessToken(input[1]);
        }
        if (input[0].equalsIgnoreCase("accesstokensecret")) {
            twitterConfigBuilder.setOAuthAccessTokenSecret(input[1]);
        }
    }
    Twitter twitter = new TwitterFactory(twitterConfigBuilder.build()).getInstance();
    mTwitterConnectorsSet.add(twitter);
}

private Twitter getTweetConnector() {
        for (Twitter tc : mTwitterConnectorsSet) {
            try {
                if (tc.getRateLimitStatus() != null) {
                    if (tc.getRateLimitStatus().containsKey("/users/lookup")) {
                        if (tc.getRateLimitStatus().get("/users/lookup") != null) {
                            System.out.println("tc - "+tc);
                            System.out.println("tc rate - "+tc.getRateLimitStatus().get("/users/lookup").getRemaining());
                            if (tc.getRateLimitStatus().get("/users/lookup").getRemaining() > 2) {
                                return tc;
                            }
                        }
                    }
                }
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        }
    return null;
}