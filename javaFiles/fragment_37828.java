public class MainActivity extends AppCompatActivity {

    public int counter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);
        // get all the view.

        final TextView tv = (TextView) findViewById(R.id.winnerTextView);


        button1.setOnClickListener(listener);

        button2.setOnClickListener(listener);

        button3.setOnClickListener(listener);

        button4.setOnClickListener(listener);

        button5.setOnClickListener(listener);

        button6.setOnClickListener(listener);

        button7.setOnClickListener(listener);

        button8.setOnClickListener(listener);

        button9.setOnClickListener(listener);

       /**
        public void getWinner() {
        tv.setText("does not work");
        }
        **/

    }
}