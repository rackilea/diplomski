hubSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    private String songtoplay;
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
       // ...
       songtoplay = test2;
    }
    public void onNothingSelected(AdapterView<?> parentView) {
       // ...
       doSomethingWith(songtoplay);
    }
});