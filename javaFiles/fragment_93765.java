public class MainActivity extends AppCompatActivity
{
    EditText txtUsername,txtPass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = (EditText) findViewById(R.id.txtUserName);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        txtUsername.setText("Arvind");
        txtPass.setText("1234");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doLogin();
            }
        });
    }

    void doLogin()
    {
        if(txtUsername!=null || txtPass!=null) {
            if (txtUsername.getText() != null && txtPass.getText() != null) {
                Toast.makeText(this, "Successfully logged in..", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Username or Password can't be empty..", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(this, "Controls becomes null..", Toast.LENGTH_SHORT).show();
        }
    }
}