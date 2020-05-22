Spinner mySpinner = (Spinner) findViewById(R.id.spinner); 

arrayAdapter = new ArrayAdapter<String>(this,     android.R.layout.simple_list_item_1,     myListOfStrings);

arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

mySpinner.setAdapter(arrayAdapter);