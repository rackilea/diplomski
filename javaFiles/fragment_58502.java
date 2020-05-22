_promoScroller = new PromoScroller(new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            // !! catch message and start the activity
            Intent = new Intent(YourCurrentActivty.this, YourTargetActivity.class);
        }
    });
    _scrollerThread = new Thread(_promoScroller);
    _scrollerThread.start();