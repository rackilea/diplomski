String compareValue = "some value";
ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_state, android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
mSpinner.setAdapter(adapter);
if (compareValue != null) {
    int spinnerPosition = adapter.getPosition(compareValue);
    mSpinner.setSelection(spinnerPosition);
}