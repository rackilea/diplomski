public class MyCountDownTimer extends CountDownTimer {
    public MyCountDownTimer(long startTime, long interval) {
        super(startTime, interval);
    }

    @Override
    public void onFinish() {
        Presence.setTextSize(TypedValue.COMPLEX_UNIT_PX, 30);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        Presence.setTextSize(TypedValue.COMPLEX_UNIT_PX, 60);
    }
}