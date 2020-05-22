public class QuestionActivity extends SherlockActivity implements
    OnClickListener {

   private CountDownTimer mCountDown;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      // ...
      mCountDown = new CountDownTimer(20000, 1000) {

        @Override
        public void onFinish() {
            // myCounter.setText("Time up!");
            timeUp(context);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            myCounter.setText("Time left: "
                    + String.valueOf(millisUntilFinished / 1000));
        }
      }.start();
      // ...