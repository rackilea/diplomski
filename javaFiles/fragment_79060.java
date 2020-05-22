private Service service;

public synchronized void initialise() {
    if (service == null) {
        // load external service
        // set field to the loaded service if contacted
    }
}

public String get() {
    if (service == null) {            
        initialise(); // try and load the service again
    }
    // perform operation on the service is service is not null
}