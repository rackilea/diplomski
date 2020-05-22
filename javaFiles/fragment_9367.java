private void login() {

        String username = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        //checking if fields are not null 
       if (username.isEmpty() || password.isEmpty() || item.isEmpty()) {
       Toast.makeText(getActivity().getApplicationContext(), "Please enter name or pass or select one type!", Toast.LENGTH_SHORT).show();
        return;
        }else{
          userLogin(username, password,item);//passing value to volley
     }
   }