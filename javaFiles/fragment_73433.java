final Handler handler = new Handler();
final Runnable runnable = new Runnable() {
    @Override
    public void run() {
        myView.toggleItemVisibility();
        handler.postDelayed(this, 1000);
    }
};
handler.postDelayed(runnable, 1000);