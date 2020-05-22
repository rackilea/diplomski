var_tablesName_LV.setOnItemSelectedListener(new OnItemClickListener() {

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    String clickedvalue =(String) adapterView.getItemAtPosition(i); 
         selectedValue.add(clickedvalue);

     }