import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity{
    Cal cal;
    TextView textView;

    public void onCreate(Bundle s){
    super.onCreate(s);
    setContentView(R.layout.<your layout name>);  // You can not set id of any view here
    cal = new Cal(this);  // This is a object
    cal.cal();
    textView.setText(""+ cal.result);   // set the value instead of view object
    }
}