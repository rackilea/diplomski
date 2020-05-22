public void userLogin(View view){

    login_name = ET_NAME.getText().toString();
    login_pass = ET_PASS.getText().toString();
    String method = "login";
    BackgroundTask backgroundTask = new BackgroundTask(mContext);
    backgroundTask.execute(method, login_name, login_pass);

}