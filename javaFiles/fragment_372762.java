pool.execute(new Runnable() {
    @Override
    public void run() {
        boolean done = false;
        while (!done) {
            try {
                task.get(50, TimeUnit.SECONDS);
                done = true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                done = true;
            } catch (ExecutionException e) {
                done = true;
                // handle e.getCause()
            } catch (TimeoutException e) {
                // we need more time
                sqsClient.changeMessageVisibility(receivedMessage, 60);
            }
        }

    }
});