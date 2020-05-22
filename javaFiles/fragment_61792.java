public someClassConstructor() {

    // set 3 available threads
    ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

    // kick off service
    new Task(service).run();

}