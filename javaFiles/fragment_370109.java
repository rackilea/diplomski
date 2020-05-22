private void declarer(){
    user = (EditText)findViewById(R.id.editText_name);
    pass = (EditText)findViewById(R.id.editText_pass);
    btnlog = (Button)findViewById(R.id.login);
    //btncan = (Button)findViewById(R.id.cancel);
    btnlog.setOnClickListener(this);
    btncan.setOnClickListener(this);

    query = "SELECT * FROM table ";
    connection = CONN("databse","password","db","server");
}