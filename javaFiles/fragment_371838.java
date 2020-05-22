import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends ActionBarActivity{
    public Button button;
    public TextView text;
    public Spinner a;
    public String b;
    public int d;
    public Random r=new Random();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        text = (TextView)findViewById(R.id.answer);
        a=(Spinner)findViewById(R.id.choices);
        button=(Button)findViewById(R.id.button);

        setContentView(R.layout.activity_main);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                b=(String)a.getSelectedItem();
                if(b.equals("2")){
                    d=2+r.nextInt(1);
                    if(d==1){
                        text.setText("A");
                    }
                    else if(d==2){
                        text.setText("B");
                    }
                }
            }
        });
    }