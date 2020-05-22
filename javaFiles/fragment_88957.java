import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //setting up the elements
    EditText finInv = (EditText)findViewById(R.id.finInv);
    String finInvString= finInv.getText().toString();

    if(!TextUtils.isEmpty(finInvString){ // Do make sure to set android:inputType="number" in your XML layout file.
        int investment=Integer.parseInt(finInvString);
    }
    Button button14=(Button)findViewById(R.id.button14);

    EditText rawBroRate=((EditText) findViewById(R.id.bronzeRate));

    EditText rawSilRate=((EditText) findViewById(R.id.silverRate));

    EditText rawGoldRate=((EditText) findViewById(R.id.goldRate));

    EditText rawEliteRate=((EditText) findViewById(R.id.eliteRate));
}



}