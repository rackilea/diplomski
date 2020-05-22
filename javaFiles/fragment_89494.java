ExecutorService executorService = Executors.newFixedThreadPool(10);

final Map<Integer, Object> map = new ConcurrentHashMap<>();
map.putAll(myObjectList);

List<Future> futures = new ArrayList<>();

for (int i = 0; i < 10; i++) {
    final thread = i;

    Future future = executorService.submit(new Callable() {
        public void call() {

        List<MyObject> list;

        CSVReader reader = new CSVReader(new InputStreamReader(csvFile.getStream()));

        list = bean.parse(strategy, reader);

        int listSize = list.size();
        int rowCount = 0;

        for(MyObject myObject : list) {

            rowCount++;

            Integer key = myObject.getId();

            if(map.putIfAbsent(key, myObject) == null) {
                session.save(object);                
            } else {
                myObject = map.get(key);
                //Do something
                session.update(myObject);
            }            

            if(rowCount % 250 == 0 || rowCount == listSize) {
                tx.flush();
                tx.clear();
            }
        };

        tx.commit();

        return "Thread " + thread + " completed."; 

    });  

    futures.add(future);  
}

for(Future future : futures) {
    System.out.println(future.get());
}

executorService.shutdown();