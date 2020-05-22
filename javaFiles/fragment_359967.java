public void onClick(View view) {

    class PostLogingDataTask extends AsyncTask<Void,Void,Void>  
    { 
        protected Void doInBackground (Void... t)
        {
            postLoginData();
        }


          protected void onPostExecute(Void v){
             // turns the text in the textview "Tbl_result" into a text string called "tblresult"
             TextView tblresult = (TextView) findViewById(R.id.tbl_result);
             // If "tblresult" text string matches the string "Login Successful! Please Wait..." exactly, it will switch to next activity
                if (tblresult.getText().toString().equals("Login Successful! Please Wait...")) {
                      Intent intent = new Intent(this, Homepage.class);
                     //take text in the username/password text boxes and put them into an extra and push to next activity 
                      EditText uname2 = (EditText)findViewById(R.id.txt_username);
                      String username2 = uname2.getText().toString();
                      EditText pword2 = (EditText)findViewById(R.id.txt_password);
                      String password2 = pword2.getText().toString();
                      intent.putExtra("username2", username2 + "&pword=" + password2);
                      startActivity(intent);
                   }    
        }
       }

            new PostLogingDataTask ().execute();
}