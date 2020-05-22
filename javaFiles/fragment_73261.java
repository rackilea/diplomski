volatile boolean shutdown = false;

public void shutdown() {
   shutdown = true;
}

public void run() {
    while(!shutdown) { 
        ... do your work here
    }
    ... perform any cleanup work here