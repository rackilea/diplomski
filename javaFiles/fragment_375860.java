sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ItemData data = sp.getSelectedItem();
            int res = data.getImageId();  //change Integer type to int  if error exists
            myView.setImageDrawable(getResources().getDrawable(res));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });