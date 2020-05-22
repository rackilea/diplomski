spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

         // perform action by comparing position

                switch(position){
                        case 0:
                             startActivity(new Intent(this,newClass.class));
                             break;
                        case 1:
                             startActivity(new Intent(this,newClass.class));                                
                             break;
                       default:
                             break;
               }
    }
    public void onNothingSelected(AdapterView<?> parent) {
    }
});