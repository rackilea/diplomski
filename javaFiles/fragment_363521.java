import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dev2qa.example.R;
import com.dev2qa.example.broadcast.receiver.ScreenOnOffReceiver;
import com.dev2qa.example.broadcast.service.ScreenOnOffBackgroundService;

public class ScreenOnOffActivity extends AppCompatActivity {

    private ScreenOnOffReceiver screenOnOffReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_on_off);

        setTitle("dev2qa.com - Keep BroadcastReceiver Running After App Exit.");

        Intent backgroundService = new Intent(getApplicationContext(), ScreenOnOffBackgroundService.class);
        startService(backgroundService);

        Log.d(ScreenOnOffReceiver.SCREEN_TOGGLE_TAG, "Activity onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ScreenOnOffReceiver.SCREEN_TOGGLE_TAG, "Activity onDestroy");
    }
}