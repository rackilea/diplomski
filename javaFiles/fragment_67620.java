@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //variables
            tvTest = (TextView)findViewById(R.id.testview);
            testSpinner = (Spinner) findViewById(R.id.spinner1);

            testSpinner.setOnItemSelectedListener(this);
        }


public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            //Spinner spinner1 = (Spinner) findViewById(R.id.spinner);


           String testText = testSpinner.getSelectedItem().toString();
           tvTest.setText(testText);
           //recreate();

        }