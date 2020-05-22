@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    usernameField = (EditText)findViewById(R.id.username);
    passwordField = (EditText)findViewById(R.id.password);
    error = (TextView)findViewById(R.id.error);
    progress = (ProgressBar)findViewById(R.id.progress);
}