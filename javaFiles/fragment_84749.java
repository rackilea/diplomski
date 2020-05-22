public class MyActivity extends Activity {

Button b1, b2;
TextView t1, t2, t3;
String str, str1;
ToggleButton toggle;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);

    b1 = (Button) findViewById(R.id.button);
    b2 = (Button) findViewById(R.id.button2);

    t1 = (TextView) findViewById(R.id.textView1);
    t2 = (TextView) findViewById(R.id.textView2);
    t3 = (TextView) findViewById(R.id.textView3);
    toggle = (ToggleButton) findViewById(R.id.toggle);



    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            t3.setText("Hello");
            toggle.setChecked(true);

        }
    });

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          //t2.setText( ((toggle.isChecked()) ? "Success!" : (t1.getText().toString() + "1") ) );

         if(toggle.isChecked()){
          t2.setText("Success!");
         }else{
          t1.setText(t1.getText().toString() + "1");

        }
    });

}