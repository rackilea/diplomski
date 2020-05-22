alpha.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            for ( DataSnapshot ds : dataSnapshot.getChildren()){
               date.add(ds.getKey().toString());
               Log.i("date", date.toString());
                dataAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, date);


                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                spinner.setAdapter(dataAdapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        // On selecting a spinner item
                        selectedTag = parent.getItemAtPosition(position).toString();
                        Log.i("position", String.valueOf(position));

                        Toast.makeText(MainActivity.this, "Selected: " + selectedTag, Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



            }
        }