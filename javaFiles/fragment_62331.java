void theLauncher() {

    AtomicInteger jobCounter = new AtomicInteger( 0 );

    ExecutorService exec = Executors.newFixedThreadPool( Runtime.getRuntime().availableProcesses());

    exec.submit( new process_threaded( exec, jobCounter, someProcessRequest ) );
    // Can submit some other things here of course...

    // Wait for jobs to complete:
    for(;;jobCounter.get() > 0){
        synchronized( jobCounter ){ // (I'm not sure if you have to have the synchronized block, but I think this is safer.
            if( jobCounter.get() > 0 )
                jobCounter.wait();
        }
    }

    // Now you can shutdown:
    exec.shutdown();
}