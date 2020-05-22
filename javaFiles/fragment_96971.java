import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{


private CountDownTimer mCountDownTimer;
int i=0;
private ProgressBar pb;
private TextView textTimer;
private Button startButton, pauseButton;
private long startTime = 0L;
private Handler myHandler = new Handler();
long timeInMillies = 0L;
long timeSwap = 0L;
long finalTime = 0L;
int seconds = (int) (finalTime / 1000);
int minutes = seconds / 60;
int milliseconds = (int) (finalTime % 1000);

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textTimer = (TextView) findViewById(R.id.textView1);
    pb = (ProgressBar) findViewById(R.id.progressBar); // here is the key
    startButton = (Button) findViewById(R.id.button1);
    pauseButton = (Button) findViewById(R.id.button2);

    startButton.setOnClickListener(this);
    pauseButton.setOnClickListener(this);
}

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button1:
                startTime = SystemClock.uptimeMillis();
                myHandler.postDelayed(updateTimerMethod, 0);
                textTimer.setText("b1 here showing startTime" + startTime);
                break;
            case R.id.button2:
                timeSwap += timeInMillies;
                myHandler.removeCallbacks(updateTimerMethod);
                textTimer.setText("b2 showing timeSwap" + timeSwap);
                break;
    }


}

public Runnable updateTimerMethod = new Runnable() {

    public void run() {
        timeInMillies = SystemClock.uptimeMillis() - startTime;
        finalTime = timeSwap + timeInMillies;

        seconds = seconds % 60;
        int seconds = (int) (finalTime / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        int milliseconds = (int) (finalTime % 1000);
        pb.setProgress(milliseconds);   // because you call this
        textTimer.setText("" + minutes + ":" + String.format("%02d", seconds) + ":" + String.format("%03d", milliseconds));
        myHandler.postDelayed(this, 0);

    }



};

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}