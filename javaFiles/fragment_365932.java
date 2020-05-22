class Task implements Runnable {

    private Scheduler scheduler;  

    public Task(Scheduler scheduler) {
        this.scheduler = scheduler;     
    }

    public void run() {
        while(true) {           
            int limit = scheduler.getNextNumber(); // get next number
            if(limit == -1) return; // no more numbers
            System.out.println(limit);
            for(int i = 0; i < limit; i++) {
                // spin
            }
        }
    }       
}