@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
tv = new TextView(this);
this.setContentView(tv);

MyCount counter = new MyCount(5000,1000);
counter.start();
}

public class MyCount extends CountDownTimer{
public MyCount(long millisInFuture, long countDownInterval) {
super(millisInFuture, countDownInterval);
}
@Override
public void onFinish() {
tv.setText(”done!”);
}
@Override
public void onTick(long millisUntilFinished) {
tv.setText(”Left: ” + millisUntilFinished/1000);
}
}

}