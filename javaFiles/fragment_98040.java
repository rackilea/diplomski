public void onTick(long millisUntilFinished) {

    String text = String.format(Locale.GERMANY, "%02d:%02d:%03d",
            millisUntilFinished / 100000, millisUntilFinished / 1000,
            millisUntilFinished % 1000);
    mTV.setText(text);  // set the text here


}

public void onFinish() {
    if (!eq.isEmpty()) {
        this.start();
    }