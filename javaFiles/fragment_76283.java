List<String> tweets = new ArrayList<String>();

while (true) {
    String tweet = twitterInput.next();
    if ("done".equals(tweet)) break;
    tweets.add(tweet);
}