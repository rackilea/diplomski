public void onStart(){
    super.onStart();
//first edittext
    EditText txtDate =(EditText)findViewById(R.id.issue);
    txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener(){
        public void onFocusChange(View view, boolean hasfocus){
            if(hasfocus){
                DateDialog dialog=new DateDialog(view);
                FragmentTransaction ft =getFragmentManager().beginTransaction();
                dialog.show(ft, "DatePicker");

            }
        }
    });
//second edittext
    EditText txtDate2 =(EditText)findViewById(R.id.expiry);
    txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener(){
        public void onFocusChange(View view, boolean hasfocus){
            if(hasfocus){
                DateDialog dialog=new DateDialog(view);
                FragmentTransaction ft =getFragmentManager().beginTransaction();
                dialog.show(ft, "DatePicker");

            }
        }
    });
}