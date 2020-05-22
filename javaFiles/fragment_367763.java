public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextToSpeech mTTS;
    Locale[] locales = Locale.getAvailableLocales();
    List<Locale> localeList = new ArrayList<Locale>();
    List<String> country = new ArrayList<String>();

    // * - Move these two variables out here
    ArrayAdapter<String> aa;
    Spinner spin;

    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("XXX", "onCreate() was called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    // * - delay important tasks until TTS is initialized
                    startWhenTTSIsInitialized();
                }
            }
        });

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        spin = (Spinner) findViewById(R.id.spinner);

    }

    private void startWhenTTSIsInitialized() {

        Log.i("XXX", "startWhenTTSIsInitialized() was called");
        for (Locale locale : locales) {
            int res = mTTS.isLanguageAvailable(locale);
            if (res == TextToSpeech.LANG_COUNTRY_AVAILABLE) {
                sum++;
                localeList.add(locale);
                // * - 'country' is used to populate the adapter, so
                // this line must come first
                country.add(locale.getDisplayName());
            }
        }

        //Creating the ArrayAdapter instance having the country list
        // * - now it's safe to set the adapter because the country list has been populated
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        Log.i("XXX", "onItemSelected() was called");
        Toast.makeText(getApplicationContext(), country.get(position), Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

        // TODO Auto-generated method stub

    }

}