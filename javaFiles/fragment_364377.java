public void blink(TextView textView) {
    if (textView.getText() == "Blink!") {
        textView.setText("");
    } else {
        textView.setText("Blink!");
    }
}

public void blinkingTask() throws InterruptedException {
    final Handler handler = new Handler();
    final TextView textView = (TextView) findViewById(R.id.my_text);
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            blink(textView);
        }
    };

    for (int i = 0; i <= 5; i++) {
        handler.postDelayed(runnable, 1000 + (i * 1000)); // 5 delayed actions with 1000 ms interval.
    }
}