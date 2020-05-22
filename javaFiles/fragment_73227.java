// first declare the ArrayAdapter globally as a field
ArrayAdapter<String> adapter;

// inside onCreate() method, initialize the ArrayAdapter (i.e. outside the `selectWord()` method) 
// using this constructor: ArrayAdapter(Context context, int resource)
adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

// after that, set the adapter (it's empty by now)
optionView.setAdapter(adapter);

// fill the Random Options Array
selectWord();
// call update options
updateOptions();

// and use it inside the CLickListener like this
optionView.setOnItemClickListener(
          new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // whatever ...
                selectWord(); //so that it changes the options in the array
                updateOptions(); // update options in the same ArrayAdapter
})});