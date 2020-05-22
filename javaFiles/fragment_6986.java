public static void main(String[] args) throws ExecutionException, InterruptedException {
    IMap<String, Integer> map = instance.getMap("test");
    JobTracker jobTracker = instance.getJobTracker( "default" );
    KeyValueSource<String, Integer> source = KeyValueSource.fromMap( map );
    Job<String, Integer> job = jobTracker.newJob(source);

    JobCompletableFuture<Map<String, String>> future = job
            .mapper(new MaxMapper())
            .reducer(new MaxReducerFactory())
            .submit();

    System.out.println("mr max: " + future.get());
}


public static class MaxMapper implements Mapper<String, Integer, String, String> {
    private volatile String max = null;

    @Override
    public void map(String s, Integer integer, Context<String, String> ctx) {
        if (max == null || s.compareTo(max)>0) {
            max = s;
            ctx.emit("max", max);
        }
    }
}

public static class MaxReducerFactory implements ReducerFactory<String,String,String> {

    @Override
    public Reducer<String, String> newReducer(String s) {
        return new MaxReducer();
    }

    private class MaxReducer extends Reducer<String, String> {
        private volatile String max = null;

        @Override
        public void reduce(String s) {
            if (max == null || s.compareTo(max)>0) max = s;
        }

        @Override
        public String finalizeReduce() {
            return max; // == null ? "" : max;
        }
    }
}