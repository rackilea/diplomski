zipspinner.setOnItemSelectedListener(new OnItemSelectedListener()
{
    public void onItemSelected(AdapterView<?> parent,View view, int pos, long id) {
        String value = state_values[pos];
        // now get your city list against value.           
        city_values = yourWayOfGettingData(value);
        adapter2.notifyDatasetChanged();
    }

    public void onNothingSelected(AdapterView parent) {
      // Do nothing.
    }

});