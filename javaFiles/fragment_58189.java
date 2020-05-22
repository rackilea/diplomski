import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main2Activity extends AppCompatActivity {

private EditText Enter_Info;
private RadioButton radioButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    Enter_Info = (EditText) findViewById(R.id.Enter_boxID);
    Enter_Info.setVisibility(View.GONE);

    radioButton = (RadioButton)findViewById(R.id.my_radio_button);
    radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                Enter_Info.setVisibility(View.VISIBLE); 
            }else{
                Enter_Info.setVisibility(View.GONE);
            }
        }
    });

   }
}