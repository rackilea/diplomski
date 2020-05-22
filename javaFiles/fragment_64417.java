public class CrawlerImpl implements Crawler {

    private final ParallelExecutor executor;

    public CrawlerImpl(final ParallelExecutor executor) {

        this.executor = executor;
    }

    @Override
    public void crawl(final String url) {

        Future<String> future = executor.invoke(new Invokable<String>() { ... });

    }
}