TextView textout1;
EditText textIn1;
Button convert;
static int x;
//int x=Integer.parseInt(textIn1.getText().toString());
//double fahrenheit = 1.8*x;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    convert = (Button) findViewById(R.id.button1);
    textIn1=(EditText) findViewById(R.id.editText1);
    textout1=(TextView) findViewById(R.id.textView1);
    convert.setOnClickListener(new View.OnClickListener() {

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            x=Integer.parseInt(textIn1.getText().toString());
            double fahrenheit = 1.8*x;
            textout1.setText(""+fahrenheit);
        }
    });

}