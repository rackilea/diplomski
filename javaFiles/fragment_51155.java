String resikox_;
String untung1_; // and the others

// Create an ArrayAdapter using the string array and a default spinner layout
// Create a separate one for each spinner resiko,untung1,untung2,untung3
ArrayAdapter<CharSequence> adapter = ArrayAdapter
            .createFromResource(getActivity(), R.array.dataobjects_array,
                    android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
resiko.setAdapter(adapter);
// Create a separate one for each spinner resiko,untung1,untung2,untung3
resiko.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        resikox_ = parent.getItemAtPosition(position).toString();
        SelectedItemMethod(resikox_)
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //DO WHATEVER OR NOTHING
                }
});

// Class method to do your item selection stuff.
public void SelectedItemMethod(String item){

    if (item.equals("Sangat Rendah")) {
        untung1.setVisibility(View.VISIBLE);
        untung2.setVisibility(View.GONE);
        untung3.setVisibility(View.GONE);
    }
    //etc, etc for all your spinners or break it up, as you please