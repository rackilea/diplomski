public class Scraper {


    //assuming this is the method where you want to use ArticleBuilder
    public void scrape() {
        getArticleBuilder();
    }

    //You can even pass constructor arguments to this method. 
    //They will be used to match a constructor on the target bean and that gets invoked
    @Lookup
    public ArticleBuilder getArticleBuilder() {
        //Spring creates a runtime implementation of this method.
        return null;
    }
}