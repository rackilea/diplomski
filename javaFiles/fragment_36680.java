private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        final String[] spinnerValueArray = new String[]{"Andrew-15","Jack-20","John-25","Smith-18","Martin-15"};
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerValueArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name;
                String version="";
                String [] values = spinnerValueArray[position].split("-");
                if(values.length > 1){
                    name = values[0];
                    version = values[1];
                }else{
                    name = values[0];
                }

                Toast.makeText(MyActivity.this,"Name : "+name+" Age : "+version,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }