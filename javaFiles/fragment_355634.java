Handler handler = new Handler();
handler.post(new Runnable() {

    @Override
    public void run() {
        // do the task here
        handler.postDelayed(this, milliseconds); // set time here to refresh textView
    }
});