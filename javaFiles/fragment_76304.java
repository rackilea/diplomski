public static Set<String> fetchFromTable(int table) {
    String sql = "select * from testkeyspace.test_table_" + table + ";";
    Set<String> result = new HashSet<String>();
    // populate result with your SQL statements
    // ...
    return result;
}

public static Set<String> fetchFromAllTables() throws InterruptedException, ExecutionException {
    // Create a ListeningExecutorService (Guava) by wrapping a 
    // normal ExecutorService (Java) 
    ListeningExecutorService executor = 
            MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    List<ListenableFuture<Set<String>>> list = 
            new ArrayList<ListenableFuture<Set<String>>>(); 
    // For each table, create an independent thread that will 
    // query just that table and return a set of user IDs from it
    for (int i = 0; i < 10; i++) {
        final int table = i;
        ListenableFuture<Set<String>> future = executor.submit(new Callable<Set<String>>() {
            public Set<String> call() throws Exception {
                return fetchFromTable(table);
            }
        });
        // Add the future to the list
        list.add(future);
    }
    // We want to know when ALL the threads have completed, 
    // so we use a Guava function to turn a list of ListenableFutures
    // into a single ListenableFuture
    ListenableFuture<List<Set<String>>> combinedFutures = Futures.allAsList(list);

    // The get on the combined ListenableFuture will now block until 
    // ALL the individual threads have completed work.
    List<Set<String>> tableSets = combinedFutures.get();

    // Now all we have to do is combine the individual sets into a
    // single result
    Set<String> userList = new HashSet<String>();
    for (Set<String> tableSet: tableSets) {
        userList.addAll(tableSet);
    }

    return userList;
}