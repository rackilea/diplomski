public class FacilityScreen extends AppCompatActivity implements  View.OnFocusChangeListener{

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_facilty_screen);
        editText = (EditText) findViewById(R.id.enter_location);
        editText.setOnFocusChangeListener(this);

    }


    @Override
    public void onFocusChange(View view, boolean b) {
        if(view==editText){
            // perfom your action here
        }
    }
}