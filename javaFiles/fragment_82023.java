import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends Activity {

    private TextView daysBox;
    private boolean running;
    private Calendar thatDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daysBox = (TextView) findViewById(R.id.main_day);

        thatDay = Calendar.getInstance();
        thatDay.set(Calendar.DAY_OF_MONTH, 25);
        thatDay.set(Calendar.MONTH, 11); // 0-11 so 1 less
        thatDay.set(Calendar.YEAR, 2014);
        thatDay.set(Calendar.HOUR, 0);
        thatDay.set(Calendar.MINUTE, 0);
        thatDay.set(Calendar.SECOND, 0);
        thatDay.set(Calendar.AM_PM, 0);

        startDateCalculator();
    }

    protected void onPause() {
        super.onPause();
        running = false;
    }

    protected void onResume() {
        super.onResume();
        running = true;
    }


    private class CountdownTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... args) {
            while (running) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }

                publishProgress();
            }
            return null;
        }

        protected void onProgressUpdate(Void... res) {
            super.onProgressUpdate(res);

            long diff = (thatDay.getTimeInMillis() - System.currentTimeMillis()) / 1000;
            long days = diff / (60 * 60 * 24);
            long hours = diff / (60 * 60) % 24;
            long minutes = diff / 60 % 60;
            long seconds = diff % 60;


            daysBox.setText("" + "" + days + "d " + hours + ":" + minutes + ":" + seconds + " ");
        }
    }

    public void startDateCalculator() {

        new CountdownTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}