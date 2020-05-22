public class MainActivity extends Activity
 {
 String passw;
 TextView textView;
 Button button;
 EditText editText;


@Override
public void onCreate(Bundle savedInstanceState)
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
textView = (TextView) findViewById(R.id.textView1);
editText = (EditText) findViewById(R.id.editText1);
button = (Button) findViewById(R.id.button1);
button.setOnClickListener(new View.OnClickListener() {
public void onClick(View p1)
{
  passw = editText.getText().toString();
  if (passw.equals("kev"))
  {
  Toast.makeText(MainActivity.this, "corrrect " + passw, Toast.LENGTH_SHORT).show();
  startActivity(new Intent(MainActivity.this,NextActivity.class));
  } else {
  Toast.makeText(MainActivity.this, "incorrect " + passw, Toast.LENGTH_SHORT).show();
  }
}
});
}
}