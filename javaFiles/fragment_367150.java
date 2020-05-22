import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ThreadSample extends AppCompatActivity {

    Handler uiHandler = new Handler();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_sample);
        textView = findViewById(R.id.textView);
        NameCounter runnable = new NameCounter();
        new Thread(runnable).start();
    }

    class NameCounter implements Runnable {
        int count = 0;
        boolean show = true;
        @Override
        public void run() {
            while (true) { // add your customized condition here to exit from the loop.
                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (show)
                            textView.setVisibility(View.VISIBLE);
                        else
                            textView.setVisibility(View.GONE);
                    }
                });
                try {
                    if (show) {
                        Thread.sleep(10000);
                        show = false;
                    } else {
                        Thread.sleep(5000);
                        show = true;
                    }
                } catch (Exception e) {
                    Log.e("ERROR", e.getMessage());
                }
            }
        }
    }
}