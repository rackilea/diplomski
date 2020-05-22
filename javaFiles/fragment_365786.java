static List<String> myOptions;

.... 
    if (myOptions == null) {
        myOptions = Arrays.asList((getResources().getStringArray(R.array.my_options)));
    }

...

    int value = myOptions.indexOf(getString(R.string.my_string_one));