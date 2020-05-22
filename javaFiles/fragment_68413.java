public class MainActivity extends AppCompatActivity implements View.OnClickListener {

EditText edt1,edt2;
TextView txtans;
Button btnsum;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    edt1=findViewById(R.id.edt1);
    edt2=findViewById(R.id.edt2);
    txtans=findViewById(R.id.txtans);
    btnsum=findViewById(R.id.btnsum);
    btnsum.setOnClickListener(this);

}

@Override
public void onClick(View v) {
    if(v.getId()==R.id.btnsum){
        float n1,n2;
        String value1=edt1.getText().toString();
        String value2=edt2.getText().toString();

        if(value1.equals("") || value1.equals(".")){
            n1=0;
        }else {
            n1= Float.parseFloat(value1);
        }
        if(value2.equals("")|| value2.equals(".")){
            n2=0;
        }else{
            n2= Float.parseFloat(value2);
        }
        float ans=n1+n2;


        txtans.setText(ans+"");

    }
}