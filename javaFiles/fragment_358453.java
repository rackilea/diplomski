ArrayAdapter<String> gradesArrayAdap = new ArrayAdapter<String>(
            getActivity(), R.layout.spinnerlayout, gradeAlphabetic);

    gradesSpinner.setAdapter(GradesArrayAdapter);


  gradeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int arg2, long arg3) {

            getGrades();

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    });