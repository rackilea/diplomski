int totalThreads = allQueriesWeight.size();
Map<String,Future<List>> map = new HashMap<>;
ExecutorService taskExecutor = Executors.newFixedThreadPool(totalThreads);
for (String query : allQueriesWeight) {//allQueriesWeight is an arraylist containing sql server queries
    SearchTask searchTask = new SearchTask(query);
    Future<List> submit = taskExecutor.submit(searchTask);
    map.put(query ,submit );
}