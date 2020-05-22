final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        updateLogs();
    }
}, 100);