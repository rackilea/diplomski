public class MyActivity extends Activity implements View.OnClickListener {

Button button1, button2, button3;

@Override
public void onCreate(Bundle bundle) {
    super.onCreate();

    ...

    button1 = (Button) findViewById(R.id.button1);
    button2 = (Button) findViewById(R.id.button2);
    button3 = (Button) findViewById(R.id.button3);

    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
}

@Override
public void onClick(View v) {
   switch(v.getId()) {
       case R.id.button1:
       // do stuff; You can called your method from here also.
       break;
       case R.id.button2:
       // do stuff;
       break;
   ...
 }
}