public class SecondActivity extends Activity {

    TextView myAwesomeTextView;

         @Override
      public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

       myAwesomeTextView = (TextView) findViewById(R.id.myAwesomeTextView);
       myAwesomeTextView.setText("My Awesome Text");


    }
   }