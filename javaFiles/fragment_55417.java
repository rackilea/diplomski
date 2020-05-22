public class MainActivity extends Activity {

 Button b;
 int max = 500;
 TextView vTextView;
 int j = 2;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  b = (Button) findViewById(R.id.button1);
  vTextView = (TextView) findViewById(R.id.textView1);

  b.setOnClickListener(new OnClickListener() {

   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub

    for (int i = j; i <= max; i++) {
     if (isPrimeNumber(i)) {
      vTextView.setText(i+"");
      j = i+1;
      break;
     }
    }

   }
  });

 }

 public boolean isPrimeNumber(int number) {

  for (int i = 2; i <= number / 2; i++) {
   if (number % i == 0) {
    return false;
   }
  }
  return true;
 }

}