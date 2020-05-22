Calendar now = Calendar.getInstance();
Calendar nextHour = Calendar.getInstance();
nextHour.add(Calendar.HOUR, 1);
nextHour.set(Calendar.MINUTE, 0);
nextHour.set(Calendar.SECOND, 0);

long difference = nextHour.getTimeInMillis() - now.getTimeInMillis();

new CountDownTimer(difference, 1000) {

public void onTick(long millisUntilFinished) {
    mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
    }

    public void onFinish() {
        mTextField.setText("done!");
    }
}.start();