Spinner spinner = (Spinner) findViewById(R.id.num_cells_spinner);
String[] array = getResources().getStringArray(R.array.settings_cells_array);

Integer[] intArray = new Integer[array.length];
for(int i = 0; i < array.length; i++) {
    intArray[i] = Integer.parseInt(array[i]);
}

// Create an ArrayAdapter using the string array and a default spinner layout
ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
android.R.layout.simple_spinner_dropdown_item, intArray);

// Apply the adapter to the spinner
spinner.setAdapter(adapter);