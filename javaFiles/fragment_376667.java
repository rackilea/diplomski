class Task implements Runnable {
    private final ScheduledExecutorService service;

    public Task(ScheduledExecutorService service){
        this.service = service;
    }

    public void run(){
        try{
             //do stuff
        }finally{
            //Prevent this task from stalling due to RuntimeExceptions.
            long untilNextInvocation = //calculate how many ms to next launch
            service.schedule(new Task(service),untilNextInvocation,TimeUnit.MILLISECONDS);
        }
    }
}