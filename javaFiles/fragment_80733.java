public class Home_Foodcourt extends AppCompatActivity implements View.OnClickListener {
EditText username,userpassword;
Button user_login;
TextView user_register;
FoodCourt_UserLoginDatabase foodCourt_userDatabase;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home__foodcourt);
    foodCourt_userDatabase=new FoodCourt_UserLoginDatabase(this);

    username=(EditText)findViewById(R.id.username);
    userpassword= (EditText) findViewById(R.id.loginpassword);
    user_login=(Button)findViewById(R.id.login_submit);
    user_register= (TextView) findViewById(R.id.user_newregister);

    user_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(Home_Foodcourt.this,FoodCourt_Register.class);
            startActivity(i);
        }
    });

    user_login.setOnClickListener(this);

}

@Override
public void onClick(View view) {

    String name=username.getText().toString();

    //############ I've added the section below. ###########
    SharedPreferences preferences = 
    PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putString("Name",name);
    editor.apply();
    //############ SharedPref section complete. ############

    String password=userpassword.getText().toString();
   String Admin="aDminSN";
    String Pass= foodCourt_userDatabase.Login(name);

  if(password.equals(Pass))   //
    {
           Message.message(this,"Log in Successfully");
        Intent i=new Intent(Home_Foodcourt.this,Userhome.class);
        i.putExtra("Username",name);
        startActivity(i);

        }else
        {
            Message.message(this,"Login Failed");
        }

}