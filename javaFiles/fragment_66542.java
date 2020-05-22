if(etUsername.getText().toString().trim().length()==0) {
    etUsername.setError("this field should be filled");
    return;
} else if(etPassword.getText().toString().trim().length()==0) {
    etPassword.setError("this field should be filled");
    return;
}