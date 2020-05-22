private Handler handler = new Handler();
private Runnable postToServerRunnable = new Runnable() {
    @Override
    public void run() {
        // TODO: PUT CODE HERE TO HANDLE CURRENT VALUE OF EDIT TEXT AND SEND TO SERVER
    }
};

private TextWatcher textWatcher = new TextWatcher() {
    @Override
    public void afterTextChanged(Editable arg0) {}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // remove existing callback (timer reset)
        handler.removeCallbacks(postToServerRunnable);
        // 500 millisecond delay. Change to whatever delay you want.
        handler.postDelayed(postToServerRunnable, 500);
    }
};