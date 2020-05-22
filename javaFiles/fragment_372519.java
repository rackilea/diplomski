@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    EditText kilometers = (EditText) findViewById(R.id.KilometersText);
    kilometers.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            onClickedText(v);
        }
    });

    // repeat this for the miles EditText

    // you'll need to add an id for the radio group for this to work:

    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
    radioGroup.setOnCheckedChangedListener(new RadioGroup.OnCheckedChangedListener() {

        // I leave the code inside here for you to do as an exercise
    });
}