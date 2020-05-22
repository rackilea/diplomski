Bundle extras = getIntent().getExtras();
if (extras == null) {
  return;
}
// get data via the key
String value1 = extras.getString(Intent.EXTRA_TEXT);
if (value1 != null) {
  // do something with the data
}