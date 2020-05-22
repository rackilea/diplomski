ExecutorService executor = Executors.newFixedThreadPools(5);
//lets say we have 5 workers with us.

//then submitting all your work (a runnable) to the factory
for(int i=0;i<n;i++){
    executor.submit(new work(someData[i]));
}