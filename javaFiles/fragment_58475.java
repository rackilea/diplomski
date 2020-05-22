public class Test {

    private final ThreadPoolExecutor threadPoolExecutor;

    public Test(int coreSize, int maxSize) {
        this.threadPoolExecutor = new ThreadPoolExecutor(coreSize,maxSize, 50, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
    }


    public void submit(String[] files) {
        for(String temp: files){
            //addToDict(temp,dictonary,conn);
            //new Scraper(temp,dictonary,conn).run();
            Scraper obj=new Scraper(temp,dictonary,conn);
            threadPoolExecutor.submit(obj);

            //System.out.println((ammountOfFiles--)+" files left");
        }
    }

    public void shutDown() {
        this.threadPoolExecutor.shutdown();
    }
}