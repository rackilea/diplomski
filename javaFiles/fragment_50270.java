public class HomeActivity extends AppCompatActivity {

    TextView mUsername, muserid;
    Button mDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mUsername = this.findViewById(R.id.username);
        muserid = this.findViewById(R.id.userid);
        mDone = this.findViewById(R.id.done);
        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent i = this.getIntent();
        mUsername.setText(i.getStringExtra(LoginActivity.INTENTKEY_USERNAME));
        muserid.setText(String.valueOf(i.getLongExtra(LoginActivity.INTENTKEY_USERID,0)));
    }
}