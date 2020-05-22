class TweetComparator implements Comparator<Tweet> {
    @Override
    public int compare(Tweet t1, Tweet t2) {
        return Long.compare(t1.getMillis(), t2.getMillis()); 
    }
}