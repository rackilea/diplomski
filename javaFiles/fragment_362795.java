public class MySessionHandler extends StompSessionHandlerAdapter {
    private final CountDownLatch latch;

    public MySessionHandler(final CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void afterConnected(StompSession session, 
                               StompHeaders connectedHeaders) {
        try {
            // do here some job
        } finally {
            latch.countDown();
        }
    }
}