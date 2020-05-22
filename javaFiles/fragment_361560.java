@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ...................
    ......................
    emailedittext = (EditText) findViewById(R.id.emailedittext);
    passwordedittext = (EditText) findViewById(R.id.passwordedittext);
    mStatusTextView = (TextView) findViewById(R.id.mStatus);
    mDetailTextView = (TextView) findViewById(R.id.mDetail);

    loginbutton = (Button) findViewById(R.id.login);
    signupbutton = (Button) findViewById(R.id.signup);
    signoutbutton = (Button) findViewById(R.id.signout);

    loginbutton .setOnClickListener(this);
    signupbutton .setOnClickListener(this);
    signoutbutton .setOnClickListener(this);
    .................
    ......................
}