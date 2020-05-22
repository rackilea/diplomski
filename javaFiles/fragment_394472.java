public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (num1text.getText().toString().isEmpty()
                || num2text.getText().toString().isEmpty()) {
            Toast msg = Toast.makeText(getBaseContext(),
                    "You Should Put Numbers To Do Calculation",
                    Toast.LENGTH_LONG);
            msg.show();
        } else {
        }
    }

    public void calcadd(View v) { // here
        EditText number1text = (EditText) findViewById(R.id.num1text);
        EditText number2text = (EditText) findViewById(R.id.num2text);
        Integer num1text = Integer.parseInt(number1text.getText().toString());
        Integer num2text = Integer.parseInt(number2text.getText().toString());
        Integer ans = num1text + num2text;

        TextView answer = (TextView) findViewById(R.id.ans);
        answer.setText("Answer:" + ans.toString());
    }

    public void calcaminus(View v) { // here
        EditText number1text = (EditText) findViewById(R.id.num1text);
        EditText number2text = (EditText) findViewById(R.id.num2text);
        Integer num1text = Integer.parseInt(number1text.getText().toString());
        Integer num2text = Integer.parseInt(number2text.getText().toString());
        Integer ans = num1text - num2text;

        TextView answer = (TextView) findViewById(R.id.ans);
        answer.setText("Answer:" + ans.toString());
    }

    public void calcadivide(View v) { // here
        EditText number1text = (EditText) findViewById(R.id.num1text);
        EditText number2text = (EditText) findViewById(R.id.num2text);
        Integer num1text = Integer.parseInt(number1text.getText().toString());
        Integer num2text = Integer.parseInt(number2text.getText().toString());
        Integer ans = num1text / num2text;

        TextView answer = (TextView) findViewById(R.id.ans);
        answer.setText("Answer:" + ans.toString());
    }

    public void calcmultiply(View v) { // here
        EditText number1text = (EditText) findViewById(R.id.num1text);
        EditText number2text = (EditText) findViewById(R.id.num2text);
        Integer num1text = Integer.parseInt(number1text.getText().toString());
        Integer num2text = Integer.parseInt(number2text.getText().toString());
        Integer ans = num1text * num2text;

        TextView answer = (TextView) findViewById(R.id.ans);
        answer.setText("Answer:" + ans.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // here
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}