public class TimeoutThreadExample {

    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private static final RestTemplate restTemplate = createRestTemplate();

    private static RestTemplate createRestTemplate(){
       HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
       requestFactory.setReadTimeout(READ_TIME_OUT);
       requestFactory.setConnectTimeout(CONNECTION_TIME_OUT);
       return new RestTemplate(requestFactory);
     }

    public String getData() {
        Future<String> future = executor.submit(new Task(restTemplate));
        String response = null;

        try {
            response = future.get(500, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return response;
    }
}