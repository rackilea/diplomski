mp.start();
Handler handler=new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        mp.stop();
    }
}, 20 * 1000);