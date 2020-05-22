public static void main(String[] args) {
    // declare and create task
    TimerTask taskNew = new TimerTask() {
        // runs our task
        @Override
        public void run() {
            System.out.println("Timer running...");

        }
    };
    // declare and create timer
    Timer myTimer = new Timer();


    /* schedule the timer (task scheduled, delay in ms before task is
     * execution, period in ms between successive tasks executions
     */
    myTimer.schedule(taskNew, 500, 1000);

}