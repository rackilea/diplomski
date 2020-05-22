textView.post(new Runnable() {
    @Override
    public void run() {
        number++;
        textView.setText("counting: " + number);
        if (number < 100) {
            textView.postDelayed(this, 50);
        }
    }
});