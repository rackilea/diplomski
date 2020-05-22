public class AddContact extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);


    Spinner spinner = (Spinner) findViewById(R.id.scrollViewMain);   

    ArrayAdapter<CharSequence> Adapter =
            ArrayAdapter.createFromResource(this, R.array.phone_array, android.R.layout.simple_spinner_item);

    // Specify the layout to use when the list of
    // choices appears
    spinner.setAdapter(Adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_contact, menu);
        return true;
    }

}