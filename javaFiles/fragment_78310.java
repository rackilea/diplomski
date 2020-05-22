import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int state = View.GONE;
    public static final String STATE_MESSAGE = "ImageViewState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // consider to use a switch in an improved version since it has only two states
        Button changeState = findViewById(R.id.changeState);
        changeState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == View.GONE){
                    state = View.VISIBLE;
                } else {
                    state = View.GONE;
                }
            }

        });

        Button nextActivity = findViewById(R.id.nextActivity);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(STATE_MESSAGE, state);
                startActivity(intent);
            }
        });
    }
}