String[] data = new String[] {"Default","Cambodian","Chinese","Korean","English","Spanish","Vietnamese"};
    TextView txttvPS=(TextView) findViewById(R.id.tvPS);

            Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, data);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1 .setAdapter(adapter);
            spinner1 .setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> arg0, View arg1,  int pos, long arg3) {
                    // TODO Auto-generated method stub  
                    txttvPS.setText(spinner1.getItemAtPosition(pos));
                }
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }
            });