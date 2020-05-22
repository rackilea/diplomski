AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.edt);
    String[] array = {"abc", "bcd", "cde", "def", "efg", "fgh", "PREM"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>
            (this, android.R.layout.select_dialog_item, array);

    autoCompleteTextView.setAdapter(adapter);
    autoCompleteTextView.postDelayed(new Runnable() {
        @Override
        public void run() {
            autoCompleteTextView.setText("PREM");
            autoCompleteTextView.showDropDown();

        }
    }, 10);