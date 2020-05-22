button.setOnClickListener(new OnClickListener(){
    public void onClick (View V){
    if(checkLogin(etUsername.getText().toString(), etPassword.getText().toString()) == 1){
        Toast.makeText(getApplicationContext(), "Log In Success ! ", Toast.LENGTH_LONG).show();
        Intent msg1 = new Intent(Login.this, Userreg.class);
        startActivity(msg1);
    }else{
        Toast.makeText(getApplicationContext(), "Wrong Username/password combination", Toast.LENGTH_LONG).show();
    }
}