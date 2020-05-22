public void onLogin(View view){
    EditText eLogin = (EditText) findViewById(R.id.username);
    EditText ePass = (EditText) findViewById(R.id.password);
    String login = eLogin.getText().toString();
    String pass = ePass.getText().toString();
    Sql_bridge bridge = new Sql_bridge(this);
    bridge.execute("login",login,pass);
}