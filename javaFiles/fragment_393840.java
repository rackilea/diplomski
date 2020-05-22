public void collect(Set<Tweet> tweets, List<Tweet> collector)
{
     for (Tweet tweet: tweets)
     {
          collector.add(tweet); 
          if (tweet.replies != null)
             collect(tweet.replies, collector);
     }

}