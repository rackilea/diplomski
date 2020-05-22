import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

TextView myText;
private Button b1;
private Button b2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (TextView)this.findViewById(R.id.textView1);

        b1 = (Button)this.findViewById(R.id.buttonMessi);
        b1.setOnClickListener(this);

        b2 = (Button)this.findViewById(R.id.buttonRonaldo);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.buttonMessi:
            myText.setText("MESSI");
          break;
        case R.id.buttonRonaldo:
            myText.setText("RONALDO");
          break;
      }

    }

}