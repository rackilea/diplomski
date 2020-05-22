protected void onCreate(Bundle savedInstanceState) {
 //...
 }

 private void updateTextView () {
    TextView textView1 = (TextView) findViewById(R.id.textView1);
    SimpleDateFormat timeNow = new SimpleDateFormat("hh:mm:ss");
    textView1.setText(timeNow.format(new Date()));
 }