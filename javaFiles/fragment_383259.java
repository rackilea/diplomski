public class ServiceA {

    private Map<String, CompletableFuture<String>> correlationStore;

    public ServiceA() {
        correlationStore = new HashMap<>();
    }

    public String performTask(String id, String data) {

        CompletableFuture<String> futureResult = new CompletableFuture<>();
        String submissionResult = callServiceB(id, data);
        if (!"OK".equalsIgnoreCase(submissionResult)) {
            return "FAILED";
        }
        //Service B has accepted the request and is busy processing the result
        correlationStore.put(id, futureResult);
        String response = null;
        try {
            //Set a timeout to whatever is sensible
            response = futureResult.get(30, TimeUnit.SECONDS); // Thread is now blocked until complete() is called
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            if (e instanceof TimeoutException) {
                correlationStore.remove(id);
            }
            //Handle failure depending on your requirements
        }
        return response;
    }

    //This is called from API call back from Service B
    public void onResponse(String id, String responseData) {
        CompletableFuture<String> pendingResult = correlationStore.remove(id);
        if (pendingResult != null) {
            pendingResult.complete(responseData);
        } else {
            //Handle the scenario where there is not future waiting for a response
        }
    }
}