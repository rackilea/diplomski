final Handler handler = new Handler();
//class variable
count = 0;

handler.post(new Runnable() {
    @Override
    public void run() {
        updateCounter(count++);

        if(count < 120) {
            handler.postDelayed(this, 1000);
        }
    }
});