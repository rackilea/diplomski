autoCompleteTextView.setOnItemClickListener(new OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
        Country  country  = (Country) parent.getItemAtPosition(position);
        String id = country.getId();
        //other information
    }
});