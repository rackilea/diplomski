skin_spinner = (Spinner)findViewById(R.id.settings_background_spinner);
ArrayAdapter<CharSequence> skin_adapter = ArrayAdapter.createFromResource(this,
        R.array.background_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
skin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
colors_spinner.setAdapter(skin_adapter);