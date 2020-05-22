public class HelloAndroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button myPanicButton = (Button)findViewById(R.id.PanicButton);
        setContentView(R.layout.main);

        //Create an anonymous implementation of OnClickListener
        OnClickListener buttonPress = new OnClickListener() {
            public void onClick(View v) {
              // do something when the button is clicked
                // setContentView(R.layout.panic);
            }
        }
        myPanicButton.setOnClickListener(buttonPress);
    }
};