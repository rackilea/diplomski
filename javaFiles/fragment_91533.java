SyndFeedInput input = new SyndFeedInput();
    int pageNumber = 1;

    try{
        do {
            URL feedSource = new URL("https://altaonline.com/feed?paged=" + pageNumber);
            SyndFeed feed = input.build(new XmlReader(feedSource));
            pageNumber++;
        }
        while (pageNumber <= 27);
    } catch (IOException ex){
        System.out.println("IO exception occurred due to: "+ ex);
        //Handle this exception accordingly
    } catch (FeedException ex) {
        System.out.println("Feed exception occurred due to: "+ ex);
        //Handle this exception accordingly
    }