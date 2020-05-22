final String articleTitle = ...;
final String articleText = ...;
final Date pubDate = ...;
final String sourceDomain = ...;
final String sourceAuthor = ...;
final String blogCategory = ...;
final SomeClassOfYours someClassOfYours = ...;

Callable<Void> callable = new Callable<Void>() {
   public Void call() throws XmlRpcFault {
      someClassOfYours.blogPublish(articleTitle, articleText, pubDate, sourceDomain, sourceAuthor, blogCategory);
   }  
}
new SimpleTimeLimiter().callWithTimeout(callable, 5, TimeUnit.SECONDS, true);