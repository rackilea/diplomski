String sel_spinner;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Setting the values to textviews for a selected item
        tvID.setText(getName(position));

         sel_spinner=getName(position);
    }