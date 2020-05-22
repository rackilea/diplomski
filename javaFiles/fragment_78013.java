public class MyHttpResponseHandler implements Runnable {

    private HttpResponse httpResponse = null;

    public MyHttpResponseHandler(HttpResponse httpResponse){
        this.httpResponse = httpResponse;
    }
    @Override
    public void run() {
        //Do something with the httpResponse
    }
}

void processHttpResponse(){
    HttpGet httpGet = new HttpGet(url);
    HttpClient  httpClient =  new DefaultHttpClient();
    HttpResponse httpResponse = httpClient.execute(httpGet);
    ExecutorService executor = Executors.newFixedThreadPool(10);
    executor.execute(new MyHttpResponseHandler(httpResponse));
}