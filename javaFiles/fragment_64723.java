listPlaces = (Spinner)findViewById(R.id.spnPlaces);
    listScenarios = (Spinner)findViewById(R.id.spnScenario);
    String[] places = new String[] {"At the Supermarket","At the Petrol Station", "At The Spur"};       

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, places);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    listPlaces.setAdapter(adapter);

    listPlaces.setOnItemSelectedListener(new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                int position, long id) {
            // TODO Auto-generated method stub

            switch (position){
            case 0:{
                List <String> list = new ArrayList<String>();
                list.add("Tea");
                list.add("Coffee");
                list.add("Sugar");
                list.add("Milk");
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Options.this, android.R.layout.simple_spinner_dropdown_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter.notifyDataSetChanged();
                listScenarios.setAdapter(dataAdapter);
                break;
            }
            case 1:{
                List <String> list = new ArrayList<String>();
                list.add("Bread");
                list.add("Butter");
                list.add("Eggs");
                list.add("Bacon");
                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(Options.this, android.R.layout.simple_spinner_dropdown_item, list);
                dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter2.notifyDataSetChanged();
                listScenarios.setAdapter(dataAdapter2);
                break;
                }
            }

        }