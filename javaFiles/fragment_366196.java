int positionOfSelectedDataFromSpinner;

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       positionOfSelectedDataFromSpinner= position;
}