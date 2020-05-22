public class MainActivity extends AppCompatActivity {
private Button button;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    button = (Button) findViewById(R.id.button1);

    button.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")));
                }
            }
    );
}
}