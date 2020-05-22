public class TweetClassification
{
  //...

  public static final TweetCategory[] tweetType = new TweetCategory[TCNUMBER];

  static
  {
    for (int i=0; i<TCNUMBER; i++)
    {
      tweetType[i] = new TweetCategory();
    }
  }

  //...
}