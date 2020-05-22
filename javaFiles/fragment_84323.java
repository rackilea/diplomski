List<String> data = new ArrayList<>();
List<String> data2 = new ArrayList<>();
//populate you lists in onCreate

String tempRemovedItem ;


Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);

ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
            android.R.layout.simple_dropdown_item_1line, data);
ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
            android.R.layout.simple_dropdown_item_1line, data2);

spinner1.setAdapter(adapter1);
spinner2.setAdapter(adapter2);

spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

           //when item is selected remove it from data2 and update the adapter of the second spinner

           data2.remove(spinner1.getSelectedItem().toString());

           if(tempRemovedItem != null){
              data2.add(tempRemovedItem);
           }

           tempRemovedItem = spinner1.getSelectedItem().toString();
           adapter2.notifyDataSetChanged();


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });