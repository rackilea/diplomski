final BlockingQueue<Data> queue = …

// use a factory, instead of supplying the crawler type to pass the queue
controller.start(new WebCrawlerFactory<MyCrawler>() {
    @Override
    public MyCrawler newInstance() throws Exception {
        return new MyCrawler(queue);
    }
}, numberOfCrawlers);