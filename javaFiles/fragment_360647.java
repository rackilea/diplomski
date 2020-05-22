public class MainActivity extends Activity{

Button button;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button = (Button) findViewById(R.id.button1);
    button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            Intent i=new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("name1","Travels1");
            i.putExtra("number1","7843564358");
            i.putExtra("name2","Travels2");
            i.putExtra("number2","7664764358");
            i.putExtra("name3","Travels3");
            i.putExtra("number3","8804764358");
            startActivity(i);
        }
    });   
}