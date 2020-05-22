public class Application implements Runnable {

    private final ExecutorService pool = Executors.newCachedThreadPool();

    public void run() {
        Dao firstDao = new DaoImpl();
        Dao secondDao = new AnotherDaoImpl();

        FetchAllTask fetchAll = new FetchAllTask(firstDao);
        Future<?> fetchAllFuture = pool.submit(fetchAll);
        try {
            fetchAllFuture.get();
        } catch (Exception e) {
            // TODO handle
            System.out.println("An exception occurred!");
            e.printStackTrace();
        }
        ConcurrentSkipListSet<AnObject> items = fetchAll.getItems();
        Iterator<AnObject> it = items.iterator();
        while (it.hasNext()) {
            // insert your cancellation logic here
            // ...
            AnObject daoObj = it.next();
            FetchOneTask fetchOne = new FetchOneTask(secondDao, daoObj.getId());
            Future<?> fetchOneFuture = pool.submit(fetchOne);
            try {
                fetchOneFuture.get();
                AnObject anotherDaoObj = fetchOne.getAnObject();
                if (anotherDaoObj == null) {
                    // the object retrievied by the first dao (first datasource)
                    // is not in the second; it needs to be inserted into the second
                    System.out.println(String.format("Inserting %s", daoObj));
                    secondDao.insert(daoObj);
                } else {
                    System.out.println(String.format("Updating %s to %s", anotherDaoObj, daoObj));
                    secondDao.update(daoObj);
                }
            } catch (Exception e) {
                System.out.println("An exception occurred!");
                e.printStackTrace();
            }
        }

        Set<AnObject> itemsInSecondDb = secondDao.fetchAll();
        for (AnObject o : itemsInSecondDb) {
            System.out.println(o);
        }

        pool.shutdown();
    }

    // ... invoke the app thread from somewhere else

}