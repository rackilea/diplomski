import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.*;
import android.view.View;

public class MainActivity extends Activity implements OnClickListener {

    EditText ino;

    Button btnadd;
    Button btnsub;
    Button btnmult;
    Button btndiv;
    Button btneq;

    private float num1 = 0;
    private float num2 = 0;
    private float res = 0;

    private int operation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ino=(EditText) findViewById(R.id.ino);

        btnadd=(Button) findViewById(R.id.add);
        btndiv=(Button) findViewById(R.id.div);
        btnsub=(Button) findViewById(R.id.sub);
        btnmult=(Button) findViewById(R.id.mult);
        btneq=(Button) findViewById(R.id.eq);

        btnadd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnmult.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btneq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String s = ino.getText().toString();
        try
        {
            Float.parseFloat(s);
        }
        catch (NumberFormatException e)
        {
            s = "0.0";
        }

        String xyz="",ans;
        ino.setText(xyz);

        switch(v.getId())
        {
            case R.id.eq:
                num1=Float.parseFloat(s);

                switch (operation) {
                    case R.id.add:
                        res = num2 + num1;
                        break;
                    case R.id.sub:
                        res = num2 - num1;
                        break;
                    case R.id.mult:
                        res = num2 * num1;
                        break;
                    case R.id.div:
                        res = num2 / num1;
                        break;
                    default:
                        res = 0;
                        break;
                }
                ans=Float.toString(res);
                ino.setText(ans);
                break;
        }
        num2 = Float.parseFloat(s);
        operation = v.getId();
    }
}