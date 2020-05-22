spinner = (Spinner) findViewById(R.id.spinner);
fake_btn = (Button) findViewById(R.id.fake_btn);
fake_text = (TextView) findViewById(R.id.fake_text);

fake_btn.setOnClickListener(new OnClickListener() {
    public void onClick(View v)
    {
        spinner.performClick();
    }
});

spinner_manual.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    public void onItemSelected(AdapterView parentView, View childView, int position, long id)
    {           
        String value = (String) spinner.getItemAtPosition(position);
        fake_text.setText(value);
    }
    public void onNothingSelected(AdapterView parentView) {}  
});