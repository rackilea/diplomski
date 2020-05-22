case BTHandler.STATE_CONNECTED:
    setContentView(R.layout.activity_connected);
    Toast.makeText(getApplicationContext(), R.string.title_connected_to, Toast.LENGTH_SHORT).show();
    Log.v("Log", "Connected");
    TextView tv = (TextView)findViewById(R.id.textView);
    tv.setText("Connected");
    break;