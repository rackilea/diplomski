@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.my_button).setOnClickListener(this);

        txtUserName=(EditText)this.findViewById(R.id.editText1);
        txtPassword=(EditText)this.findViewById(R.id.editText2);
    }