spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

        String selected_val= spinner.getSelectedItem().toString();

        Toast.makeText(getApplicationContext(), selected_val ,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
});