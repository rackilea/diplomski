public class MainActivity extends Activity {
double firstNum = 0;
double secondNum = 0, answerNum;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final EditText first = (EditText) findViewById(R.id.editText1);
    final EditText second = (EditText) findViewById(R.id.editText2);

    final TextView answer = (TextView) findViewById(R.id.textView1);

    Button calc = (Button) findViewById(R.id.button1);
    calc.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub


            if (first.getText().toString().equals("")
                    || second.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Please Enter value",
                        Toast.LENGTH_SHORT).show();
            } else {
                firstNum = Double.parseDouble(first.getText().toString());
                secondNum = Double.parseDouble(second.getText().toString());
                answerNum = (firstNum + secondNum);
                DecimalFormat total = new DecimalFormat("###,###,###.##");
                answer.setText("Answer is " + total.format(answerNum));
            }
        }
    });
}
}