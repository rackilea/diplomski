class ServiceExecutor {
    void runLongRoutine() {
        try {
            several(param1);
            calls();
            to(param2);
            different(param3, param1);
            methods();
        } catch (CustomException e) {
            handleCustomException(e);
        } catch (IOException e) {
            handleIOException(e);
        } catch (NetworkException e) {
            handleNetworkException(e);
        }
        //to be continued
    }

    private void handleCustomException(CustomException e) { ... }
    private void handleIOException(IOException e) { ... }
    private void handleNetworkException(NetworkException e) { ... }
}