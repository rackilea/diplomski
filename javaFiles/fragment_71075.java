spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int arg2, long arg3) {
            if (arg2 == 0) {
                spinner2.setSelection(0);
                spinner3.setSelection(0);
                spinner4.setSelection(0);
                spinner2.setEnabled(false);
                spinner3.setEnabled(false);
                spinner4.setEnabled(false);
            }else{
                spinner2.setEnabled(true);
                spinner3.setEnabled(true);
                spinner4.setEnabled(true);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    });