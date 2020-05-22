public class Level1 extends Activity implements OnClickListener{

    ImageButton A,B,C,D,E,F,G,H,I,J;
    TextView ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        A = (ImageButton) findViewById(R.id.A);
        B = (ImageButton) findViewById(R.id.B);
        C = (ImageButton) findViewById(R.id.C);
        D = (ImageButton) findViewById(R.id.D);
        E = (ImageButton) findViewById(R.id.E);
        F = (ImageButton) findViewById(R.id.F);
        G = (ImageButton) findViewById(R.id.G);
        H = (ImageButton) findViewById(R.id.H);
        I = (ImageButton) findViewById(R.id.I);
        J = (ImageButton) findViewById(R.id.J);
        ans = (TextView) findViewById(R.id.ans);
        A.setOnClickListener(this);
        B.setOnClickListener(this);
        C.setOnClickListener(this);
        D.setOnClickListener(this);
        E.setOnClickListener(this);
        F.setOnClickListener(this);
        G.setOnClickListener(this);
        H.setOnClickListener(this);
        I.setOnClickListener(this);
        J.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        String typed = ans.getText().toString();

        String resourceName = getResources().getResourceEntryName(id);
        ans.setText(typed + resourceName);

        checkAns();

    }



    public  void checkAns() {
        String check =ans.getText().toString();
        if(check.equalsIgnoreCase("ABC")){
            Toast.makeText(Level1.this, "correct" ,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(Level1.this, "NO" ,Toast.LENGTH_SHORT).show();
        }
    }
}