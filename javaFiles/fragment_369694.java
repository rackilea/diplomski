Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        ((Activity) GamePanel.this.getContext()).finish();
    }
}, 5000);