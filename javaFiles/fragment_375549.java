spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // call the Activity's method here and send the selected item.          
        ((MainActivity)activity).doSomething(parent.getItemAtPosition(position));
        dialog.dismiss();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});