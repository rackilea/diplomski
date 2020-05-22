@Override
    protected void onStart() {


        //GetStudentResults();


     semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;
                    case 1:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;
                    case 2:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


      year_of_study.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;
                    case 1:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;
                    case 2:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;
                    case 3:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;
                    case 4:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;
                    case 5:
                        inn = getIntent();
                        regTester = inn.getStringExtra("RegNumber");
                        sem = semester.getSelectedItem().toString();
                        yr = year_of_study.getSelectedItem().toString();
                        Load(regTester, sem, yr);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        //load2();

        super.onStart();

    }