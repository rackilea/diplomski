public class LoginActivity extends AppCompatActivity {

    public static final String INTENTKEY_USERNAME = "IK_USERNAME";
    public static final String INTENTKEY_USERID = "IK_USERID";

    Button mloginbtn;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        mloginbtn = this.findViewById(R.id.loginbtn);
        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext,HomeActivity.class);
                i.putExtra(INTENTKEY_USERNAME,"Fred");
                i.putExtra(INTENTKEY_USERID,99L);
                startActivity(i);
                finish();
            }
        });
    }
}