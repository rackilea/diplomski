Button login;
Button register;

@SuppressLint("NewApi")
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login); //<-- here the layout is inflated
    //Now you can retrieve your elements from the XML file.
    login = (Button) findViewById(R.id.login);
    register = (Button) findViewById(R.id.register);
    /*****/
}