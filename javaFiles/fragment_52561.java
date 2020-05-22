@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Set your parent view
    setContentView(R.layout.main_layout);

    // Get the message from the intent
    Intent intent = getIntent();
    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    // Get the reference to the TextView and update it's content
    TextView textView = (TextView)findViewById(R.id.my_text_view);
    textView.setText(message);
}