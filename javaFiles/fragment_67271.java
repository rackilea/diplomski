@Override
    protected void onPreExecute() {
         // show ProgressDialog  here
    }
    @Override
    protected void onPostExecute(Void result) {
        // parse json here and start Home Activity
       //.........your code here
       if (test.equals("200")) {
            Log.i("Login Success", "Success message");
            Intent intent = new Intent(contxt,HomeActivity.class);
            contxt.startActivity(intent);
        } else {
            Log.e("Login Error", "Error converting result ");
        }

     }