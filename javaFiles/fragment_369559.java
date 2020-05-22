private EditText etNewLogin;
private EditText etNewPassword;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.users);
    tNewLogin = (EditText) findViewById(R.id.etChangeLogin);
    tNewPassword = (EditText) findViewById(R.id.etChangePassword);
}