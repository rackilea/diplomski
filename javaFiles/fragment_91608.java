spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

         // perform action by comparing position

             if(position==0){
                startActivity(new Intent(this,newClass.class));
               }
    }
    public void onNothingSelected(AdapterView<?> parent) {
    }
});