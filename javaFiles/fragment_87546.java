String[] arrayShow = getResources().getStringArray(R.array.range_types);

            ArrayList<String> lst = new ArrayList<String>();
            lst.addAll(Arrays.asList(arrayShow));


            final ArrayAdapter<String> adapterType1 = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, lst);

        adapterType1
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerType1.setAdapter(adapterType1);

spinnerType1.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
                // TODO Auto-generated method stub
                adapterType2.remove(adapterType1.getItem(arg2));
                adapterType2.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub


            }
        });