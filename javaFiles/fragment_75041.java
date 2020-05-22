class Service{
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);
    private List<Future<?>> futures;
    public void execute(Collection<Runnable> runs){
        futures = runs.stream()
                .map(r -> executor.submit(r))
                .collect(Collectors.toList());
    }

    public boolean isComplete(){
        for (Future<?> future : futures) 
            if (!future.isDone()) return false;

        return true;
    }
}