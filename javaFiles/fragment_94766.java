spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        // your code here

   String selecteditem = spinner.getselecteditem().tostring();
   textview.settext(Selecteditem);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {
        // your code here
    }

});