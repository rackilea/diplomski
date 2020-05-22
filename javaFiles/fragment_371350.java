public class CountDownTimerUtils extends CountDownTimer {

private TextView mTextView;

/**
 * @param textView          The TextView
 * @param millisInFuture    The number of millis in the future from the call
 *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
 *                          is called.
 * @param countDownInterval The interval along the way to receiver
 *                          {@link #onTick(long)} callbacks.
 */
public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval) {
    super(millisInFuture, countDownInterval);
    this.mTextView = textView;
}
@Override
public void onTick(long millisUntilFinished) {
    mTextView.setText(millisUntilFinished / 1000 + "sec");
    mTextView.setClickable(false);
}
@Override
public void onFinish() {
    mTextView.setText("retry");
    mTextView.setClickable(true);
    mTextView.setFocusable(true);
}
}