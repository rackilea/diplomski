public abstract class Query implements Callable<List<Result>> {
    private final String query; // gets set in the constructor

    public abstract List<Result> querySearchEngine();
    @Override
    public List<Result> call() {
        return querySearchEngine(query);
    }
}

public class Querier {   
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public List<Result> queryAll(List<Query> queries) {
        List<Future<List<Result>>> futures = executor.submitAll(queries);
        List<Result> aggregatedResults = new ArrayList<Result>();
        for (Future<List<Result>> future : futures) {  
            aggregatedResults.addAll(future.get());  // get() is somewhat similar to join?
        }  
        return aggregatedResults;
    }
}