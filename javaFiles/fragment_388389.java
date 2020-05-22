public class Activity2 extends Activity implements OnClickListener {
RadioButton pic2radioA;
RadioButton pic2radioB;
RadioButton pic2radioC;
RadioButton pic2radioD;
RadioButton pic2radioE;
Button button2;

  int A2;
    int B2;
    int C2;
    int D2;
    int E2;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activity2);
    A2 = getIntent().getExtras().getInt("A1");
    B2 = getIntent().getExtras().getInt("B1");
    C2 = getIntent().getExtras().getInt("C1");
    D2 = getIntent().getExtras().getInt("D1");
    E2 = getIntent().getExtras().getInt("E1");

    .......rest of the code.

 }