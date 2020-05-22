public class NextActivity extends Activity
{
Button button2;
TextView textView2;
@Override 
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.next);
  textView2 = (TextView) findViewById(R.id.textView1);
  textView2.setText("Welcome Kevin");
  button2 = (Button) findViewById(R.id.button1);
  button2.setOnClickListener(new OnClickListener(){
  public void onClick(View p1)
  {
    textView2.setText("button clicked");
  }
  });
 }
 }