public class FortuneActivity extends Activity {

    private FortuneBox mFortuneBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        mFortuneBox = new FortuneBox(this);

        // Declare our View variables and assign them the Views from the layout file
        final TextView fortuneLabel = (TextView) findViewById(R.id.fortuneTextView);
        Button showFortuneButton = (Button) findViewById(R.id.showFortuneButton);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fortune = mFortuneBox.getFortune();
                // Update the label with dynamic fortune
                fortuneLabel.setText(fortune);
            }
        };
        showFortuneButton.setOnClickListener(listener);

    }
}