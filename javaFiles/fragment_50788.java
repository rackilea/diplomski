Button btnLogIn = (Button) findViewById(R.id.logIn);
btnLogIn.setOnClickListener(new OnClickListener() {
    public void onClick(View v)
    {
        Intent intent = new Intent(Mainactivity.this, DisplayLogInActivity.class);
        startActivity(intent);
    } 
});