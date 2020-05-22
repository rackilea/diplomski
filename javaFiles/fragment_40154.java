final MainActivity main = this; // Just need to make it final
final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        main.updateLogs();
    }
}, 100);