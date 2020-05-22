do { // optional loop choice
    try{
        attemptReconnection();
        break; // Connection was successful, break out of the loop
    } catch(Exception e){
        // Exception thrown, do nothing and move on to the next connection attempt (iteration)
        log.error(e);
    }
}while(true);