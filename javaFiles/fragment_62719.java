spinner.setOnItemSelectedListener(new OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
            long arg3) {
            // here get the selected value and do whatever you want
    }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // ignore this if you're not going to provide a "no-selection" option
        }
    });