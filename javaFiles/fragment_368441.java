//Create spinner dynamically
Spinner spinner = new Spinner(context);

//Ready your data for spinner
String[] plants = new String[]{"Laceflower", "California sycamore", 
        "Mountain mahogany", "Butterfly weed", "Carrot weed"};

//Create ArrayAdapter for spinner with system default layout for views
ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
        this, 
        android.R.layout.simple_spinner_item, 
        plants
);

//Attach adapter to spinner
spinner.setAdapter(spinnerArrayAdapter);