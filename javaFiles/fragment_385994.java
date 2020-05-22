import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends Activity{

    static int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        Button go = (Button)findViewById(R.id.button1);
        go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText sec = (EditText)findViewById(R.id.editText1);
                n = Integer.parseInt(sec.getText().toString());
                Intent go = new Intent("com.nerdwin15.demo.alarmdemo.AlarmMainActivity");
                startActivity(go);
            }
        });
    }

}