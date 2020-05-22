public class CountDown extends CountDownTimer {

    Button button;
    public CountDown (long millisInFuture, long countDownInterval, Button button) {
        super(millisInFuture, countDownInterval);
        this.button = button;
    }


    @Override
    public void onFinish() {
        System.out.println("Timer Completed.");
        button.setText("Timer Completed.");
    }

    @Override
    public void onTick(long millisUntilFinished) {
        button.setText((millisUntilFinished/1000)+"");
        System.out.println("Timer  : " + (millisUntilFinished/1000));
    }

}