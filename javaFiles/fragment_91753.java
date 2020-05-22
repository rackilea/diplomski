public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mesage);

        Intent intent = getIntent();


        String message = "";

        if (intent == null) {
            Log.d("Intent", "Intent is null :(");
        }

        try {
            message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        } catch (Exception e) {
            Log.d("Message", "Message is null");
        }


        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setTextSize(40);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }
}