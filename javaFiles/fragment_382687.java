mikesButton = (Button) findViewById(R.id.mikesButton); /// ref to the location by id

public boolean onLongClick(View v) {    //// Callback method
     TextView Change = (TextView) findViewById(R.id.mikesButton);
     Change.setText("Good job, it changed when you held onto the button!");
     return true;
}