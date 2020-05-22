import android.app.Activity;
import android.os.Bundle;
public class testing002 extends Activity {
private Sounds myotherclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numeracy);
        new Sounds().Randomsoundforrightanswer(this);
    }
}