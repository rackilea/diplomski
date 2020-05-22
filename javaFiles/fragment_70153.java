public class HomScr extends AppCompatActivity implements CallBackListener {
    TextView tv;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.das_boa);

    initialize();
}

private void initialize(){

    tv = findViewById(R.id.tv);
    Button btn = findViewById(R.id.btn);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ProEdiCon dia_fra = new ProEdiCon();
            dia_fra.show((this).getSupportFragmentManager(), "pro_edi_con");
        }
    }
}


private void method_to_run_onDismiss(){
    tv.setText("method to run is executed");
    Toast.makeText(this, "method to run successfully executed on dismiss Dialog Fragment", Toast.LENGTH_SHORT).show();
}

@Override
public void onDismiss() {
    method_to_run_onDismiss();
}

}