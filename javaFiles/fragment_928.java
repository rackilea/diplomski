final Handler h = new Handler();
h.post(new Runnable() {
    @Override
    public void run() {
        updateTime();
        h.postDelayed(this, 1000);
    }
});