// get the saved string from shared preferences
String name1 = sharedpref.getString("name1", "default value");
// set reference to the text view
textv = (TextView) findViewById(R.id.text1);
// set the string from sp as text of the textview
textv.setText(name1);