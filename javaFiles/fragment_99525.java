import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_form);
      LinearLayout linearLayout = (LinearLayout) findViewById(R.id.container);

      TextView textView = new TextView(this);
      textView.setText("Hello world");
      textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,   LinearLayout.LayoutParams.WRAP_CONTENT));

      linearLayout.addView(textView);
   }
}