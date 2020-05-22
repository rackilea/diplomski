List<TweetQueryTweet> tweets = new ArrayList<>();

public String getQuery() {
    return query;
}

public void setQuery(String query) {
    this.query = query;
}

public List<TweetQueryTweet> getTweets() {
    return tweets;
}

public void setTweets(List<TweetQueryTweet> tweets) {
    this.tweets = tweets;
}

public void addTweets(TweetQueryTweet... queryTweets) {
    for (TweetQueryTweet tweet : queryTweets) {
        this.tweets.add(tweet);
    }
}

@Override
public String toString() {
    return String.format("[TweetQuery - query:%s, tweets:%s]",query, tweets);
}