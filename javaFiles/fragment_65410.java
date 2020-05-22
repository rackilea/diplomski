class MyHTTPTransaction extends Thread {
    public MyHTTPTransaction(.....) {
        /* ... */
    }
    public void run() {
        /* do the stuff with the connection */
    }
    public void abortNow() {
        /* roughly close the connection ignoring exceptions */
    }
}