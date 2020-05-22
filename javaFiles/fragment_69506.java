public void onCreate(Bundle savedInstance) {
super.onCreate(savedInstance);

Bundle extras = getIntent().getExtras();
String text = extras.getString(MY_STRING_KEY);

    dataselected.setText(text);
}