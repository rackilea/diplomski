public class QuestionActivity extends Activity implements OnClickListener{

    // NEW: add counterTimer as a member
    private CountDownTimer counterTimer;

    // NEW: implement onResume
    @Override
    public void onResume() {
        setTimer();
        super.onResume();
    }

    // CHANGE: setTimer should be changed as follows
    public void setTimer() {
        long finishTime = 5;
        // NOTE: use the member, instead of a local
        counterTimer = new CountDownTimer(finishTime * 1000, 1000) {
            public void onFinish() {
                //code to execute when time finished
            }

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;

                if (seconds < 10) {
                    txtTimer.setText("" + minutes + ":0" + seconds);
                } else {
                    txtTimer.setText("" + minutes + ":" + seconds);
                }
            }
        };
        counterTimer.start();
    }
}