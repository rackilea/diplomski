import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity 
{
private ProgressBar pr;

private EditText tv;
private EditText tv2;
private boolean titleboolean;
private boolean jokeboolean;

@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    pr=(ProgressBar)findViewById(R.id.progressBar);
    tv = (EditText) findViewById(R.id.tv);
    tv2 = (EditText) findViewById(R.id.tv2);


    TextView tV = new TextView(this); 
    tV.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence 
  s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, 
    int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            setProgress();

        }
    });
    tv2.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence 
 s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, 
int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            setProgress();

        }
    });
}

public void setProgress() {
    pr.setProgress(30);
    if (tv.getText().toString().matches("")) {
        titleboolean = true;
    } else
        titleboolean = false;
    if (tv2.getText().toString().matches("")) {
        jokeboolean = true;
    } else
        jokeboolean = false;
    if (titleboolean) {
        pr.setProgress(60);
    }
        if (jokeboolean) {
            pr.setProgress(100);
        }
    }
}