private final Object fetcherMutex = new Object();
private final Object downloaderMutex = new Object();

public String[] getNextLink(){
    synchronized (fetcherMutex) { /* ...  */ }
}

public String[] getNextFile(){
    synchronized (downloaderMutex) { /* ...  */ }
}