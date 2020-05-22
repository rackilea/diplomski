String[] schools = new String[]{
            "School 1",
            "School 2",
            "School 3"
    };


    final String[] schoolCodeArray = new String[] {
            "password1",
            "password2",
            "password3"
    };

    Spinner schoolList = findViewById(R.id.schoolList);
    ArrayAdapter<String> schoolListAdapter = new ArrayAdapter<String>(CreateAccount.this, android.R.layout.simple_spinner_dropdown_item, schools);
    schoolList.setAdapter(schoolListAdapter);

    schoolList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (schoolCodeArray[position].equals(editText.getText().toString().trim())) {
                // your code here
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });