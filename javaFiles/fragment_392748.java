spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            spinner.setSelection(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            spinner.setSelection(0);
        }
    });