import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    public Date start;
    public Date end;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);
        Button endButton = (Button) findViewById(R.id.stopButton);
        final EditText dateEditText = (EditText) findViewById(R.id.dateEditText);
        final EditText hoursEditText = (EditText) findViewById(R.id.hoursEditText); //the one I want to update

        final DateFormat df = new SimpleDateFormat("MM/dd/yy");

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                setTimeElapsed(hoursEditText);
                handler.postDelayed(this, 100);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                start = new Date();
                dateEditText.setText(df.format(start));
                hoursEditText.setText("");
                handler.post(thread);
            }
        });


        endButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(handler != null)
                handler.removeCallbacksAndMessages(null);
            }
        });


    }

    public void setTimeElapsed(EditText hoursEditText) {
        end = new Date();
        long diff = end.getTime() - start.getTime();
        String diffFormatted = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(diff),
                TimeUnit.MILLISECONDS.toMinutes(diff)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diff)),
                TimeUnit.MILLISECONDS.toSeconds(diff)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff)));

        hoursEditText.setText(diffFormatted);
    }
}