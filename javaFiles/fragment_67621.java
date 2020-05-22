@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //variables
            tvTest = (TextView)findViewById(R.id.testview);
            testSpinner = (Spinner) findViewById(R.id.spinner1);


testSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
         String testText = testSpinner.getSelectedItem().toString();
               tvTest.setText(testText);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {
        // your code here
    }

});
}