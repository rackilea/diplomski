@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);

    mSignupButton.setOnClickListener(new View.OnClickListener(){...});
    mLoginButton.setOnClickListener(new View.OnClickListener(){...});
    ...
}