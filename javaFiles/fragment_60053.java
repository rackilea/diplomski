public class LoginActivity extends ActionBarActivity  {
EditText et, et2;
ImageButton ib5;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    et = (EditText) findViewById(R.id.editText);
    et2 = (EditText) findViewById(R.id.editText2);
    ib5 = (ImageButton) findViewById(R.id.imageButton5);

    ib5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            login();
        }
    });
}

public void login(){
    new LoginTask(this, et.getText().toString(), et2.getText.toString()).execute();
}
}