public class Demo {
    private final Set<Page> pages = ConcurrentHashMap.newKeySet();
    private final Set<Page> submittedPages = ConcurrentHashMap.newKeySet();

    private final ExecutorService executorService;

    public Demo(final int numberOfThreads) {
        this.executorService = Executors.newFixedThreadPool(numberOfThreads);
    }

    public void start(String url) {
        this.submitTask(new Page(url))
            // shutdown even in the exceptional case
            .whenComplete((_void, throwable) -> executorService.shutdown())
            .join(); // wait for completion before doing something with pages

        // do something with pages
    }

    private CompletableFuture<Void> submitTask(final Page page) {
        // use a single add to avoid check-then-act anti-pattern
        if(this.submittedPages.add(page)) {
            return CompletableFuture.supplyAsync(new Task(page)::call, executorService)
                // compose with recursively encountered tasks
               .thenCompose(receivedPage -> {
                   this.savePage(receivedPage);
                   return this.submitCollectedLinks(receivedPage);
               });
        }

        // do nothing when already submitted
        return CompletableFuture.completedFuture(null);
    }

    private CompletableFuture<Void> submitCollectedLinks(final Page page) {
        return CompletableFuture.allOf(page.getLinks()
          .stream().map(Page::new).map(this::submitTask)
          .toArray(CompletableFuture<?>[]::new));
    }

    private void savePage(final Page page) {
        this.pages.add(page);
    }
}