public void addCluster(Cluster c) {
    TweetCluster tweetCluster = new TweetCluster(c);
    tweetClusters.add(tweetCluster);
}

public List<TweetCluster> getTweetClusters() {
    return tweetClusters;
}

public void setTweetClusters(List<TweetCluster> tweetClusters) {
    this.tweetClusters = tweetClusters;
}

@Override
public String toString() {
    return String.format("[TweetClusters:%s]", tweetClusters);
}