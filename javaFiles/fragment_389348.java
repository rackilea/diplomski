public void onClick(View v) {
    if(username.getText().toString().equals("test") &&
                          password.getText().toString().equals("test")){
        // responding to the User inputs
        Toast.makeText(getApplicationContext(), "Login Successfully !!!",  
                                      Toast.LENGTH_LONG).show();     
        Intent intent = new Intent(LoginActivity.this, Home.class);
        startActivity(intent); 
    }else{
        Toast.makeText(getApplicationContext(), "Login Not Successful !!!", 
                                      Toast.LENGTH_LONG).show();   
    }
}