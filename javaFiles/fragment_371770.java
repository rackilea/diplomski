@Override
protected void onPreExecute() {
    super.onPreExecute();
    username = user.getText().toString();
    password = pass.getText().toString();
    pDialog = new ProgressDialog(Login.this);

    ...
}