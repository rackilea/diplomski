//Read Java docs for details about construcutor...
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 100, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //Do your task...
        }
    };

    executeTasks(poolExecutor, runnable, false, false); //Compute last 2 parameters as you need and pass on required values.

public static void executeTasks(ThreadPoolExecutor poolExecutor, Runnable runnable, boolean isUnderLoad, boolean isOverLoad){
    if(isOverLoad && isUnderLoad){
        //Handle this situation, this should not be allowed, probably a coding bug can result this...
    }
    poolExecutor.submit(runnable);
    if(isUnderLoad){
        poolExecutor.setCorePoolSize(5);
    }
    if(isOverLoad){
        poolExecutor.setCorePoolSize(20);
    }
}