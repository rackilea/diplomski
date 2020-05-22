public class beforemain extends Activity implements OnClickListener {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.beforemain);

    Button mBtn1 = (Button) findViewById(R.id.button1);
    Button mBtn2 = (Button) findViewById(R.id.button2); //Just like #1
    mBtn1.setOnClickListener(this);
    mBtn2.setOnClickListener(this); //Also like #1

}

@Override
public void onClick(View v) {
    switch(v.getId()) { //Get the id of the button that was clicked
    case R.id.button1:
        Intent i = new Intent(beforemain.this, Splash1.class);
        startActivity(i);
        break;
    case R.id.button2:
        Intent i = new Intent(beforemain.this, Splash2.class);
        startActivity(i);
        break;
    }
}