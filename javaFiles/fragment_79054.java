public class Page {
  private final int depth;
  private final String url;

  public Page(String url, int depth) {
    this.url = url;
    this.depth = depth;
  }

  private Set<String> fetchLinks(html) {
    // use your implementation, but return the links instead
    // of adding them to a queue. Using a set removes duplicates
  }

  /**
    * Fetches the URL represented by this page, and
    * add pages to the queue for all pages linked to
    * by the page.
    */
  public void visitPage(Queue<Page> workQueue) {
     String html = fetchContent(url);

     if (depth == 5) {
       // in too deep!
       return;
     }

     for (String link : fetchLinks(html)) {
       workQueue.add(new Page(link, depth + 1));
     }
   } 
}