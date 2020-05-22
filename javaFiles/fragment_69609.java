mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
     {
        PlayerModel playerModel = goodModelArrayList.get(position);
        String id=playerModel.getId();
        String title=playerModel.getTitle();
    }
    public void onNothingSelected(AdapterView<?> parent) {
    }
});