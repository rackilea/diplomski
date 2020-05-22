public class MainScreen extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private Animation scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        scale = AnimationUtils.loadAnimation(this, R.anim.gps_button_animation);
      btn = (Button) findViewById(R.id.ImageButton); 
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        btn.startAnimation(scale); //gives me error to scale//
    }

    public void InfoActivity(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }
    }