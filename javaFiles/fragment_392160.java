spnUnitTypes.setOnItemSelectedListener(new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int postion, long arg3) {

            if (types[postion].equals("Time")){

                adaptFrom = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, TimeUnits);
                adaptTo = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, TimeUnits);

        }else if (types[postion].equals("Mass")){

            adaptFrom = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, MassUnits);
            adaptTo = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_item, MassUnits);
        }

            spnFromUnit.setAdapter(adaptFrom);
            spnToUnit.setAdapter(adaptTo);



        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    });