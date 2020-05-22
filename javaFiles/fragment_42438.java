public class MyService {

    @Setter
    private MyDao myDao;
    //Immutable
    private volatile Cache cache;

    //Static factory method
    public static MyService create(){
        MyService retVal = new MyService();
        cache = Cache.emptyCache();
        updateCache();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int get(){
         //Retrieving from cache
         return cache.getNext();
    }

    @Transactional
    @Scheduled(fixedDelay=60000)
    public void updateCache() {
            //the runnable queries the MyDao,
            //which in turn currently implemented as a DB-dao
            //The cache is assigned after computation
    }
}