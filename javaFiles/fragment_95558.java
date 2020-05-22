String[] words = new String[]{
"ADD", "DELETE", "UPDATE", "DELETE FROM", "SELECT"};

ArrayAdapter<String> adapter = new ArrayAdapter<String>(
this, android.R.layout.simple_spinner_item, words);

mQueryEditor.setThreshold(1);
mQueryEditor.setAdapter(adapter);
mQueryEditor.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
//mQueryEditor.showDropDown();  // Need to comment this line