private static class PromoScroller implements Runnable {

    private Handler _scrollHandler;

    public PromoScroller(Handler scrollHandler) {
        _scrollHandler = scrollHandler;
    }

    @Override
    public void run() {
        // .. 
        _scrollHandler.sendEmptyMessage(0);
    }
}