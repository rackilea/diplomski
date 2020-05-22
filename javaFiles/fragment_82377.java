protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //Set the text view as the activity layout
    setContentView(messageTextView);

    //Get the message from the intent
    Intent intent = getIntent();
    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    //Create the text view
    TextView messageTextView= (TextView) findViewById(R.id.messageTextView);
    messageTextView.setText(message);

    //Set back button
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}