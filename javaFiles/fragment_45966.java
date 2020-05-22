public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String features = "\"liga\"=0";

        TextView textView = (TextView) findViewById(R.id.textview);
        Typeface tf = Typeface.createFromAsset(this.getAssets(), "MenksoftHawang" +
                ".ttf");
        textView.setTypeface(tf);
        textView.setFontFeatureSettings(features);

        textView.setText("IJ ij");
    }
}