public class HelloAndroid extends Activity {
    //Create an anonymous implementation of OnClickListener
    private OnClickListener buttonPress = new OnClickListener() {
        public void onClick(View v) {
          // do something when the button is clicked
            // setContentView(R.layout.panic);
        }
    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button myPanicButton = (Button)findViewById(R.id.PanicButton);
        setContentView(R.layout.main);
        myPanicButton.setOnClickListener(buttonPress);
    }
};