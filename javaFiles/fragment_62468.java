public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    DatabaseHelper.User current_user = null;
    EditText loginUsername, loginPassword;
    TextView status;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = this.findViewById(R.id.status);
        loginUsername = this.findViewById(R.id.login_username);
        loginPassword = this.findViewById(R.id.login_password);
        login = this.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        dbHelper = new DatabaseHelper(this);
        dbHelper.insertNewUser("Admin","adminpassword");

    }

    private void loginUser() {
        if (
                loginUsername.getText().toString() == null
                        || loginUsername.getText().toString().length() < 1
                        ||loginPassword.getText().toString() == null
                        || loginPassword.getText().toString().length() < 1) {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if ((current_user = dbHelper.checkUser(loginUsername.getText().toString(),loginPassword.getText().toString())) != null) {
            loginUsername.setVisibility(View.GONE);
            loginPassword.setVisibility(View.GONE);
            login.setText("DO SOMETHNG");
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Hello " +
                            current_user.getUserName() +
                            " you are logged in so you can do something!",Toast.LENGTH_SHORT).show();
                }
            });
            status.setText("Successfully Logged-In as " + current_user.getUserName());
        } else {
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }
}