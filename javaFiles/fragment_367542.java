private class DownloadFilesTask extends AsyncTask<String,String,String> {
       String email;
       boolean emailValid = true;

        @Override
        protected void onPreExecute() {
           super.onPreExecute();

           Email= (EditText)findViewById(R.id.email);
           email= Email.getText().toString().trim();


           if(!isEmailValid(email)) {
                Toast.makeText(Registration.this,"Not a valid Email",Toast.LENGTH_LONG).show();
                emailValid = false;

                return;
           }
        }

        @Override
        protected String doInBackground(String... params) {
           if(emailValid) {
               // now you know it isn't valid
               return "invalid";
           }
        }

       // @Override
        protected void onPostExecute(String file_uri) {
            if(file_uri.equals("invalid") {
                // now you know it isn't valid event here
            }
        }
    }