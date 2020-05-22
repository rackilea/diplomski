ExecutorService executor = Executors.newFixedThreadPool(5);

List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();    
for(int i=0;i<5;i++){
    tasks.add(Executors.callable(new getLogFile(doneSignal, i)));
}

executor.invokeAll(tasks);
// Here tasks are completed