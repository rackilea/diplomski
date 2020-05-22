ExecutorService pool = Executors.newFixedThreadPool(10);

public static void populate(String marketId) {
    //irrelevant code removed

    List<Company> companies = mongo().find(new Query(c), Company.class);
    List<Future> futures = new ArrayList<Future>();

    for(Company comp : companies) {
        futures.add(comp.updateData(market));
    }

    for(Future future: futures) {
        future.get()
    }
}

public Future<Boolean> updateData(Market market) {
  return pool.submit(new Callable<Boolean>() {
            @Override
            public Void call() throws Exception {
                //do your slow stuff here;
                return false;
            }
        })

}