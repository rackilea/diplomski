Runnable runnable = new Runnable() {
        @Override
        public void run ( ) {
            // Do the work of this task.
            ZonedDateTime zdt = ZonedDateTime.now( ZoneId.systemDefault() ); // Capture the current moment.
            System.out.println( "Current moment: " + zdt ); // Report the current moment.
            // Schedule the next run of this task.
            scheduledExecutorService.schedule( this , 10L , TimeUnit.SECONDS );  // Delay will not be *exactly* this amount of time due to interruptions of scheduling cores on CPU and threads by the JVM and host OS.
        }
    };