public class MainActivity extends AppCompatActivity implements View.OnClickListener   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        PartiallyTransparentLayout layout = findViewById(R.id.magic_layout);

        final int maxWidth = layout.getWidth();
        final int maxHeight = layout.getHeight();

        Path p = new Path();
        p.moveTo((float) (Math.random() * maxWidth), (float) (Math.random() * maxHeight));
        p.lineTo((float) (Math.random() * maxWidth), (float) (Math.random() * maxHeight));
        p.lineTo((float) (Math.random() * maxWidth), (float) (Math.random() * maxHeight));
        p.close();

        layout.setClipping(p);
    }