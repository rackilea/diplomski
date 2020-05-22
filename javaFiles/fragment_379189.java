public class LoginActivity extends AppCompatActivity {

  ...

  private Button mBtnLogin;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    ...

    mBtnLogin = findViewById(R.id.login_cloudpark_btn);
  }
}