Handler timerHandler;
timerHandler = new Handler();

Runnable timerRunnable = new Runnable() {
    @Override
    public void run() {
        adapter.notifyDataSetChanged();
        timerHandler.postDelayed(this, 1000);
    }
};

timerHandler.postDelayed(timerRunnable, 1000);