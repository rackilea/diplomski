private void CreateList() {

    Spinner spn_Sections = (Spinner) findViewById(R.id.spn_Sections);
    List<String> Sections = new ArrayList<String>();
    Sections.add("Section 1");
    Sections.add("Section 2");
    Sections.add("Section 3");

    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Sections);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spn_Sections.setAdapter(dataAdapter);


    spn_Sections.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {
                case 0:
                    ClassAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Section1);
                    Toast.makeText(getApplicationContext(), "Section 1", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    ClassAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Section2);
                    Toast.makeText(getApplicationContext(), "Section 2", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    ClassAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Section3);
                    Toast.makeText(getApplicationContext(), "Section 3", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

            // sometimes you need nothing here
        }
    });

    ListView MyClasses = (ListView) findViewById(R.id.list_ClassList);
    MyClasses.setAdapter(ClassAdapter);
    MyClasses.setOnItemClickListener(this);

}