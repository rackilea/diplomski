runOnUiThread(new Runnable() {
    public void run() {
        // Update TextView here
TextView scoreTextView = (TextView)findViewById(R.id.scoreTextView);
scoreTextView.setText("Goals scored: " + goals);
    }
});