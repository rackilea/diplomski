static final int MAX_CONCURRENT_REQUESTS = 10;
static final Semaphore httpRequestsLock = new Semaphore(MAX_CONCURRENT_REQUESTS, true);

public void evaluate() throws Exception {
    Foo requestBase = null;
    HttpClient httpClient = new HttpClient();

    httpRequestsLock.acquire();
    try{
        response = httpClient.execute(requestBase);
    }
    catch (ConnectTimeoutException e) {
        httpRequestsLock.release();
        httpRequestsLock.acquire(MAX_CONCURRENT_REQUESTS); // Blocks until all current requests are done
        WifiManager wifiMan = (WifiManager) App.getContext().getSystemService(Context.WIFI_SERVICE);
        resetWifi(wifiMan); //reset android wifi, nothing special
        httpRequestsLock.release(MAX_CONCURRENT_REQUESTS);
        evaluate();
    }
}