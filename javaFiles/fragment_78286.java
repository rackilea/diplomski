public void Hey(View v) {
    TextView whatever = (TextView) findViewById(R.id.textDisplay);
    if(whatever.getText().toString().equals("Hey!")){
         whatever.setText("Ho!");
         whatever.setTextColor(Color.rgb(255, 255, 255));
         whatever.setBackgroundColor(Color.rgb(82, 218, 199));
    } else if (whatever.getText().toString().equals("Ho!"){
         whatever.setText("Hey!");
         whatever.setTextColor(Color.rgb(0, 0, 0));
         whatever.setBackgroundColor(Color.rgb(/*red RGB*/));
    }
}