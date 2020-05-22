public void crawlInternetResource(String baseDomainUrl) {
    this.baseDomainUrl = baseDomainUrl;

    Phaser phaser = new Phaser();
    executorService.execute(new Crawler(phaser, baseDomainUrl)); 
    int phase = phaser.getPhase();
    phase.awaitAdvance(phase);
}

private class Crawler implements Runnable { 

    private final Phaser phaser;
    private String urlToCrawl;

    public Crawler(Phaser phaser, String urlToCrawl) {
        this.urlToCrawl = urlToCrawl;
        this.phaser = phaser;
        phaser.register(); // register new task
    }

    public void run(){
       ...
       phaser.arrive(); //may want to surround this in try/finally
    }