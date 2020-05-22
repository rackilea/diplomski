private Handler handler = new Handler();
private Runnable runnable = new Runnable() {
    @Override
    public void run() {
        Consulta.performClick();
        handler.postDelayed(this, 1000);
    }
};