private void setSpinner(Spinner spinner, List<?> l){
    if (l != null || !l.isEmpty()){
    ArrayAdapter myAdapter = new ArrayAdapter(
            Prototype_activity.this,
            android.R.layout.simple_spinner_item,
            l);
    spinner.setAdapter(myAdapter);
    }
}