public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final Button RollButton = findViewById(id.RollButton);
    final TextView resultsTextView = findViewById(id.ResultsTV);
    final SeekBar seekBar = findViewById(id.seekBar);

    RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random(10);
                int random = rnd.nextInt(seekBar.getProgress());
                CharSequence get = resultsTextView.getText();
                get = String.valueOf(random);
            }
        });
}
}