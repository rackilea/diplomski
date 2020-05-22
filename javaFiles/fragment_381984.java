firstSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
                // TODO Auto-generated method stub

                    string selectedValue = arg0.getSelectedItem().toString();
                    if(selectedValue.equalsIgnoreCase(string1)
                    {
                        ArrayAdapter<String> firstAdapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1, firstArray);

                        secondSpinner.setAdapter(firstAdapter);//
                    }

                   else if(selectedValue.equalsIgnoreCase(string2)
                   {
                      ArrayAdapter<String> firstAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, array2);

                      secondSpinner.setAdapter(firstAdapter);

                   }
            }