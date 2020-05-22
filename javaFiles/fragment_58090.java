private void getSignInResult(GoogleSignInResult result) {

        if (result.isSuccess()) {

            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();

            String id_token = acct.getIdToken(); //add this code here to save it by use SharedPreferences 

            TextView user_name= (TextView)findViewById(R.id.userName);
            TextView email_id= (TextView)findViewById(R.id.emailId);
            user_name.setText("UserName: "+ acct.getDisplayName());
            email_id.setText("Email Id: " + acct.getEmail());
            updateUI(true);
            progress_dialog.dismiss();
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
    }

//save user login state id_token

private void saveLoginState(String id_token){

   SharedPreferences sharedpreferences = getSharedPreferences("YOUR_PREFERENCE_NAME", Context.MODE_PRIVATE);    

SharedPreferences.Editor editor = sharedpreferences.edit();

            editor.putString("GG_LOGED", id_token);

            editor.commit();

}