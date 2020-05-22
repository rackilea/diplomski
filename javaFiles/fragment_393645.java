spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position != 0)
                spinner2.setVisibility(View.GONE);
            else
                spinner2.setVisibility(View.VISIBLE);
        }

        public void onNothingSelected(AdapterView<?> parent) {}
    });