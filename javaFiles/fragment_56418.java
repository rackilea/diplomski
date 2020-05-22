import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
private Button button; // Renamed to button, not buton

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Use English words, others might read your code someday
    button = (Button) findViewById(R.id.buton_verde); 

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View b) {
            button.setBackgroundColor(Color.GREEN);
            // You are explicitly assiging the OnClickListener for this button
            // Thus, you don't need to check if b is a button
        }
    };
    // You have created the listener, now you need to assign it to the button
    button.setOnClickListener(clickListener); 
    }
}